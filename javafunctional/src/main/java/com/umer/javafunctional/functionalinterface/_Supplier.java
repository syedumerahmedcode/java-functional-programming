package com.umer.javafunctional.functionalinterface;

import java.util.List;
import java.util.function.Supplier;

public class _Supplier {


	private static final String DUMMY_DATABASE_CONNECTION_URL = "jdbc://localhost:5432/users";
	private static final String ANOTHER_DUMMY_URL = "jdbc://localhost:5432/customers";

	public static void main(String[] args) {
		System.out.println("Connection string using imperative apporach: " 
					+ getDBConnectionUrl());

		System.out.println("Connection string using declarative apporach: " 
					+ getDBConnectionUrlsSupplier.get());
		
		System.out.println("Connection string list using declarative apporach: " 
				+ getDBConnectionUrlListSupplier.get());

	}

	// Imperative approach
	static String getDBConnectionUrl() {
		return DUMMY_DATABASE_CONNECTION_URL;
	}

	// declarative approach
	static Supplier<String> getDBConnectionUrlsSupplier = () 
			-> DUMMY_DATABASE_CONNECTION_URL;

			static Supplier<List<String>> getDBConnectionUrlListSupplier = ()
					->List.of(DUMMY_DATABASE_CONNECTION_URL, ANOTHER_DUMMY_URL);
			
			
}
