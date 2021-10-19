package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {
	
	private boolean isEmailValid(String email) {
		/*
		 * A very simple validation as the purpose is to under combinator pattern 
		 */
		return email.contains("@");
	}
	
	private boolean isPhoneNumberValid(String phoneNumber) {
		/*
		 * A very simple validation as the purpose is to under combinator pattern 
		 */
		return phoneNumber.contains("+0");
	}
	
	private boolean isAdult(LocalDate dateOfBirth) {
		return Period.between(dateOfBirth, LocalDate.now()).getYears()>18;
	}
	
	public boolean isCustomerValid(Customer customer) {
		return isEmailValid(customer.getEmail()) &&
				isPhoneNumberValid(customer.getPhoneNumber()) &&
				isAdult(customer.getDateOfBirth());
	}
	

}
