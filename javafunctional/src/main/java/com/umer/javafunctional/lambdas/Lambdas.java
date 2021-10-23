package com.umer.javafunctional.lambdas;

import java.util.function.Function;

public class Lambdas {
	
	private static final String EMPTY_STRING = "  ";
	
	public static void main(String[] args) {
		Function<String, String> upperCaseName= name -> name.toUpperCase();
		System.out.println("------------------------------------------------------------");
		System.out.println("Labmda with a single line function");
		System.out.println("------------------------------------------------------------");
		System.out.println(upperCaseName.apply("Test String to uppercase"));

	}

}
