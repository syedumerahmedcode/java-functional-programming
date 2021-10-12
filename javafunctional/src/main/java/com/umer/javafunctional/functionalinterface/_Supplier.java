package com.umer.javafunctional.functionalinterface;

import java.util.function.Supplier;

public class _Supplier {

	private static final String DUMMY_DATABASE_CONNECTION_IRL = "jdbc://localhost:5432/users";

	public static void main(String[] args) {
		System.out.println("Connection string using imperative apporach: " 
					+ getDBConnectionUrl());

		System.out.println("Connection string using declarative apporach: " 
					+ getDBConnectionUrlSupplier.get());

	}

	// Imperative approach
	static String getDBConnectionUrl() {
		return DUMMY_DATABASE_CONNECTION_IRL;
	}

	// declarative approach
	static Supplier<String> getDBConnectionUrlSupplier = () 
			-> DUMMY_DATABASE_CONNECTION_IRL;

}
