package combinatorpattern;

import java.time.LocalDate;

public class Main {
	
	public static void main(String[] args) {
		Customer alice=new Customer("Alice", 
				"alice@some_email.com", 
				"+0123456789", 
				LocalDate.of(2000, 01, 01));

		// Using validation with combinator pattern
		System.out.println("Are information about Alice valid: "
				+ new CustomerValidatorService().isCustomerValid(alice));
		
		
	}

}
