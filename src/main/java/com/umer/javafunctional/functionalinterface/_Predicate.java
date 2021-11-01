package com.umer.javafunctional.functionalinterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {

	public static void main(String[] args) {

		// Normal function call
		final String validPhoneNumber = "07000030000";
		final String invalidPhoneNumberWhereInitialDigitsAreIncorrect = "09000000000";
		final String invalidPhoneNumberWhereLengthIsIncorrect = "070298300";

		System.out.println(isPhoneNumberValid(validPhoneNumber));
		System.out.println(isPhoneNumberValid(invalidPhoneNumberWhereInitialDigitsAreIncorrect));
		System.out.println(isPhoneNumberValid(invalidPhoneNumberWhereLengthIsIncorrect));

		// Using Functional Interface
		System.out.println("-----------Using declarative approach----------------");
		System.out.println(isPhoneNumberValidPredicate.test(validPhoneNumber));
		System.out.println(isPhoneNumberValidPredicate.test(invalidPhoneNumberWhereInitialDigitsAreIncorrect));
		System.out.println(isPhoneNumberValidPredicate.test(invalidPhoneNumberWhereLengthIsIncorrect));
		
		System.out.println("-----------Combining Predicates----------------");
		System.out.println(
				"Is phone number valid AND contains number 3 = " + 
				isPhoneNumberValidPredicate
				.and(conatinsNumberThreePredicate)
				.test(invalidPhoneNumberWhereLengthIsIncorrect)
			);
		
		System.out.println(
				"Is phone number valid AND contains number 3 = " + 
				isPhoneNumberValidPredicate
				.and(conatinsNumberThreePredicate)
				.test(validPhoneNumber)
			);
		
		System.out.println(
				"Is phone number valid OR contains number 3 = " + 
				isPhoneNumberValidPredicate
				.or(conatinsNumberThreePredicate)
				.test(invalidPhoneNumberWhereLengthIsIncorrect)
			);

		System.out.println("-----------Using BiPredicates----------------");
		System.out.println("Is first name Maria and last name Smith  = " + 
				firstNameMariaAndLastNameSmithBiPredicate.test("maria", "smith")
		);
		System.out.println("Is first name Maria and last name Smith  = " + 
				firstNameMariaAndLastNameSmithBiPredicate.test("john", "smith")
		);

	}

	// Declarative approach
	static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> 
				phoneNumber.startsWith("07") && 
				phoneNumber.length() == 11;
				
	static Predicate<String> conatinsNumberThreePredicate=phoneNumber ->
				phoneNumber.contains("3");
				
	static BiPredicate<String, String>	firstNameMariaAndLastNameSmithBiPredicate= (firstName, lastname) ->
				firstName.equalsIgnoreCase("Maria") && lastname.equalsIgnoreCase("Smith");

	// Imperative approach
	static boolean isPhoneNumberValid(String phoneNumber) {
		return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
	}

}
