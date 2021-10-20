package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.EnumSet;
import java.util.function.Function;
import combinatorpattern.CustomerRegistrationValidatorSet.ValidationResultPossible;

public interface CustomerRegistrationValidatorSet extends Function<Customer, EnumSet<ValidationResultPossible>>{

	static final EnumSet<ValidationResultPossible> SUCCESS_ONLY= EnumSet.of(ValidationResultPossible.SUCCESS);
	
	static CustomerRegistrationValidatorSet isEmailValidSet() {
		return customer -> customer.getEmail().contains("@") 
				? SUCCESS_ONLY
						: EnumSet.of(ValidationResultPossible.EMAIL_NOT_VALID);				
	}
	
	static CustomerRegistrationValidatorSet isPhoneNumberValidSet() {
		return customer -> customer.getPhoneNumber().startsWith("+0") 
				? SUCCESS_ONLY
						: EnumSet.of(ValidationResultPossible.PHONE_NUMBER_NOT_VALID);				
	}
	
	static CustomerRegistrationValidatorSet isAnAdultSet() {
        return customer -> Period.between(customer.getDateOfBirth(), LocalDate.now()).getYears() > 18 
        		? SUCCESS_ONLY 
        				: EnumSet.of(ValidationResultPossible.IS_NOT_AN_ADULT);
    }
	
	default CustomerRegistrationValidatorSet and(CustomerRegistrationValidatorSet other) {
		return customer ->{
			EnumSet<ValidationResultPossible> thisResult=this.apply(customer);
			EnumSet<ValidationResultPossible> otherResult= other.apply(customer);
			
			if(thisResult.equals(SUCCESS_ONLY))
				return otherResult;
			if(otherResult.equals(SUCCESS_ONLY))
				return thisResult;
			
			EnumSet<ValidationResultPossible> combinedResult=EnumSet.copyOf(thisResult);
			combinedResult.addAll(otherResult);
			
			return combinedResult;
			
			
		};
	}
	
	
	enum ValidationResultPossible {
		SUCCESS, 
		PHONE_NUMBER_NOT_VALID, 
		EMAIL_NOT_VALID, 
		IS_NOT_AN_ADULT
	}
}
