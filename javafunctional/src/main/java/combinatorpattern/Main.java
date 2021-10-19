package combinatorpattern;

import java.time.LocalDate;

import combinatorpattern.CustomerRegistrationValidator.ValidationResult;
import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {
	
	public static void main(String[] args) {
		Customer alice=new Customer("Alice", 
				"alice@some_email.com", 
				"+0123456789", 
				LocalDate.of(2000, 01, 01));

		// Using validation without combinator pattern
		System.out.println("Are information about Alice valid: "
				+ new CustomerValidatorService().isCustomerValid(alice));
		
		Customer bob=new Customer("Bob", 
				"bob_some_email.com", 
				"99123456789", 
				LocalDate.of(2020, 01, 01));
		
		// Using combinator pattern - Failure case
		final ValidationResult validationForBob = isAnAdult()
				.and(isEmailValid())
				.and(isPhoneNumberValid())
				.apply(bob);
		System.out.println("Validation For Bob: "+validationForBob);
		
		// Using combinator pattern - Success case
		final ValidationResult validationForAlice = isAnAdult()
				.and(isEmailValid())
				.and(isPhoneNumberValid())
				.apply(alice);
		System.out.println("Validation For Alice: "+validationForAlice);
		
		// The combinator checking can also be combined with throwing an exception
//		if(validationForBob!=ValidationResult.SUCCESS) {
//			throw new IllegalStateException(validationForBob.name());
//		}
		
	}

}
