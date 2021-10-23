package com.umer.javafunctional.lambdas;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Lambdas {
	
	private static final String EMPTY_STRING = "  ";
	
	public static void main(String[] args) {
		Function<String, String> upperCaseName= name -> name.toUpperCase();
		System.out.println("------------------------------------------------------------");
		System.out.println("Labmda with a single line function");
		System.out.println("------------------------------------------------------------");
		System.out.println(upperCaseName.apply("Test String to uppercase"));
		System.out.println(EMPTY_STRING);
		
		
		Function<String, String> upperCaseNameMultilineLogic= name -> {
			// multi line logic
			if(name.isBlank()) {
				throw new IllegalArgumentException("name cannot be blank");
			}
			return name.toUpperCase();
		};
		System.out.println(EMPTY_STRING);
		System.out.println("------------------------------------------------------------");
		System.out.println("Labmda with a multi line function");
		System.out.println("------------------------------------------------------------");
		/**
		 * This line should not be converted to upper case"
				+ " as the logic throws an Illegal argument exception for balnk inputs
		 */
		//System.out.println(upperCaseNameMultilineLogic.apply(""));
		System.out.println(upperCaseNameMultilineLogic.apply("Another test string to convert in upper case"));
		System.out.println(EMPTY_STRING);
		
		
		BiFunction<String,Integer, String> upperCaseNameAndDisplayAge= (name,age) -> {
			// multi line logic
			if(name.isBlank()) {
				throw new IllegalArgumentException("name cannot be blank");
			}
			
			return "The name of the person is "+name.toUpperCase()+" and the age is "+age;
		};
		System.out.println(EMPTY_STRING);
		System.out.println("------------------------------------------------------------");
		System.out.println("Labmda with a multi line Bifunction");
		System.out.println("------------------------------------------------------------");
		System.out.println(upperCaseNameAndDisplayAge.apply("Alice",99));		
		System.out.println(EMPTY_STRING);
		
	}

}
