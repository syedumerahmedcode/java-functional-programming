package com.umer.javafunctional.functionalinterface;

import java.util.function.Predicate;

public class _Predicate {
	
	public static void main(String[] args) {
		// normal function call
		final String validPhoneNumber = "07000000000";
		final String invalidPhoneNumberWhereInitialDigitsAreIncorrect = "09000000000";
		final String invalidPhoneNumberWhereLengthIsIncorrect = "070000000";
		
		System.out.println(isPhoneNumberValid(validPhoneNumber));
		System.out.println(isPhoneNumberValid(invalidPhoneNumberWhereInitialDigitsAreIncorrect));
		System.out.println(isPhoneNumberValid(invalidPhoneNumberWhereLengthIsIncorrect));
		
		System.out.println("-----------Using declarative approach----------------");
		System.out.println(isPhoneNumberValidPredicate.test(validPhoneNumber));
	}
	
	// Declarative approach
	static Predicate<String> isPhoneNumberValidPredicate= phoneNumber -> 
				phoneNumber.startsWith("07") && 
				phoneNumber.length()==11;
	
	
	// Imperative approach
	static boolean isPhoneNumberValid(String phoneNumber) {
		return phoneNumber.startsWith("07") && phoneNumber.length()==11;
	}

}
