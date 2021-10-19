package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;
import static combinatorpattern.CustomerRegistrationValidator.ValidationResult;


public interface CustomerRegistrationValidator extends Function<Customer, ValidationResult> {

	static CustomerRegistrationValidator isEmailValid() {
		/*
		 * A very simple validation as the purpose is to under combinator pattern 
		 */
		return customer -> customer.getEmail().contains("@") 
				? ValidationResult.SUCCESS
				: ValidationResult.EMAIL_NOT_VALID;
	}
	
	static CustomerRegistrationValidator isPhoneNumberValid() {
		/*
		 * A very simple validation as the purpose is to under combinator pattern 
		 */
		return customer -> customer.getPhoneNumber().startsWith("+0") 
				? ValidationResult.SUCCESS
				: ValidationResult.PHONE_NUMBER_NOT_VALID;
	}
	
	static CustomerRegistrationValidator isAnAdult() {
		return customer -> Period.between(customer.getDateOfBirth(), LocalDate.now()).getYears() > 18
				? ValidationResult.SUCCESS
				: ValidationResult.IS_NOT_AN_ADULT;		
	}
	
	default CustomerRegistrationValidator and(CustomerRegistrationValidator other) {
		return customer -> {
			final ValidationResult result = this.apply(customer);
			return result.equals(ValidationResult.SUCCESS) ? other.apply(customer) : result;
		};
	}
	
	
	enum ValidationResult {
		SUCCESS, 
		PHONE_NUMBER_NOT_VALID, 
		EMAIL_NOT_VALID, 
		IS_NOT_AN_ADULT
	}

}
