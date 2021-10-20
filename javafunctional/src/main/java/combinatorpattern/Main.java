package combinatorpattern;

import java.time.LocalDate;
import java.util.EnumSet;

import combinatorpattern.CustomerRegistrationValidator.ValidationResult;
import static combinatorpattern.CustomerRegistrationValidator.*;

import combinatorpattern.CustomerRegistrationValidatorSet.ValidationResultPossible;
import static combinatorpattern.CustomerRegistrationValidatorSet.*;


public class Main {
	
	private static final String EMPTY_STRING = "  ";

	public static void main(String[] args) {
		Customer alice=new Customer("Alice", 
				"alice@some_email.com", 
				"+0123456789", 
				LocalDate.of(2000, 01, 01));

		System.out.println(EMPTY_STRING);
		System.out.println("------------------------------------------------------------");
		System.out.println("Using validation without combinator pattern");
		System.out.println("------------------------------------------------------------");
		System.out.println("Are information about Alice valid: "
				+ new CustomerValidatorService().isCustomerValid(alice));
		System.out.println(EMPTY_STRING);
		
		Customer bob=new Customer("Bob", 
				"bob_some_email.com", 
				"99123456789", 
				LocalDate.of(2000, 01, 01));
		
		System.out.println(EMPTY_STRING);
		System.out.println("------------------------------------------------------------");
		System.out.println("Using combinator pattern - Failure case");
		System.out.println("------------------------------------------------------------");
		final ValidationResult validationForBob = isAnAdult()
				.and(isEmailValid())
				.and(isPhoneNumberValid())
				.apply(bob);
		System.out.println("Validation For Bob: "+validationForBob);
		System.out.println(EMPTY_STRING);
		
		System.out.println(EMPTY_STRING);
		System.out.println("------------------------------------------------------------");
		System.out.println("Using combinator pattern - Success case");
		System.out.println("------------------------------------------------------------");
		final ValidationResult validationForAlice = isAnAdult()
				.and(isEmailValid())
				.and(isPhoneNumberValid())
				.apply(alice);
		System.out.println("Validation For Alice: "+validationForAlice);	
		System.out.println(EMPTY_STRING);
		
		// The combinator checking can also be combined with throwing an exception
//		if(validationForBob!=ValidationResult.SUCCESS) {
//			throw new IllegalStateException(validationForBob.name());
//		}
		
		System.out.println(EMPTY_STRING);
		System.out.println("------------------------------------------------------------");
		System.out.println("Using combinator pattern - Failure case");
		System.out.println("Here we show all failing validations using a EnumSet");
		System.out.println("------------------------------------------------------------");
		final EnumSet<ValidationResultPossible> validationResultsInASet = isAnAdultSet()
				.and(isEmailValidSet())
				.and(isPhoneNumberValidSet())
				.apply(bob);
		System.out.println("Validation For Bob: "+validationResultsInASet);
		System.out.println(EMPTY_STRING);
		
		
		
		
		
	}

}
