package combinatorpattern;

import java.util.EnumSet;
import java.util.function.Function;

import combinatorpattern.CustomerRegistrationValidatorSet.ValidationResult;

public interface CustomerRegistrationValidatorSet extends Function<Customer, EnumSet<ValidationResult>>{

	
	
	enum ValidationResult {
		SUCCESS, 
		PHONE_NUMBER_NOT_VALID, 
		EMAIL_NOT_VALID, 
		IS_NOT_AN_ADULT
	}
}
