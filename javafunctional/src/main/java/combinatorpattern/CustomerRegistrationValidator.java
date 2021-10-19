package combinatorpattern;

import java.util.function.Function;
import static combinatorpattern.CustomerRegistrationValidator.ValidationResult;


public interface CustomerRegistrationValidator extends Function<Customer, ValidationResult> {

	static CustomerRegistrationValidator isEmailValid() {
		return customer -> customer.getEmail().contains("@") 
				? ValidationResult.SUCCESS 
				: ValidationResult.EMAIL_NOT_VALID;
	}
	
	
	
	
	
	
	enum ValidationResult {
		SUCCESS, 
		PHONE_NUMBER_NOT_VALID, 
		EMAIL_NOT_VALID, 
		IS_NOT_AN_ADULT
	}

}
