package com.umer.javafunctional.functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;


public class _Consumer {
	
	public static void main(String[] args) {
		// Normal java function
		final Customer maria = new Customer("Maria", "99999");
		greetCustomer(maria);
		greetCustomerV2(maria, false);
		
		// Consumer Functional interface
		greetCustomerConsumer.accept(maria);
		greetCustomerConsumerV2.accept(maria, false);
		
	}
	
	// Declarative approach
	static Consumer<Customer> greetCustomerConsumer=customer ->System.out.println(
				"Hello " + customer.customerName 
				+ ", thanks for registering phone number "
				+ customer.customerPhoneNumber);
	
	static BiConsumer<Customer, Boolean> greetCustomerConsumerV2=(customer, showPhoneNumber) -> System.out.println(
				"Hello " + customer.customerName 
				+ ", thanks for registering phone number "
				+ (showPhoneNumber ? customer.customerPhoneNumber: "********"));
	
	// Imperative approach 
	static void greetCustomer(Customer customer) {
		System.out.println("Hello " + customer.customerName 
				+ ", thanks for registering phone number "
				+ customer.customerPhoneNumber);
	}
	
	static void greetCustomerV2(Customer customer, Boolean showPhoneNumber) {
		System.out.println("Hello " + customer.customerName 
				+ ", thanks for registering phone number "
				+ (showPhoneNumber ? customer.customerPhoneNumber: "********"));
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
