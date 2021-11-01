package combinatorpattern;

import java.time.LocalDate;

public class Customer {
	
	private final String name;
	private final String email;
	private final String phoneNumber;
	private final LocalDate dateOfBirth;
	
	public Customer(String name, String email, String phoneNumber, LocalDate dateOfBirth) {
		super();
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public LocalDate getDateOfBirth() {
		return this.dateOfBirth;
	}
	
	
	
	

}
