package com.umer.javafunctional.functionalinterface;

public class _Consumer {
	
	public static void main(String[] args) {
		greetCustomer(new Customer("Maria", "99999"));
		
	}
	
	// Imperative approach 
	static void greetCustomer(Customer customer) {
		System.out.println("Hello " + customer.customerName 
				+ ", thanks for registering phone number "
				+ customer.customerPhoneNumber);
	}
	
	static class Customer{
		private final String customerName;
		private final String customerPhoneNumber;
		
		public Customer(String customerName, String customerPhoneNumber) {
			super();
			this.customerName = customerName;
			this.customerPhoneNumber = customerPhoneNumber;
		}
		
		
		
	}

}
