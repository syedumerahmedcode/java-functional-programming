package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {
	
	public boolean isEmailValid(String email) {
		/*
		 * A very simple validation as the purpose is to under combinator pattern 
		 */
		return email.contains("@");
	}
	
	public boolean isPhoneNumberValid(String phoneNumber) {
		/*
		 * A very simple validation as the purpose is to under combinator pattern 
		 */
		return phoneNumber.contains("+0");
	}
	
	public boolean isAdult(LocalDate dateOfBirth) {
		return Period.between(dateOfBirth, LocalDate.now()).getYears()>18;
	}
	

}
