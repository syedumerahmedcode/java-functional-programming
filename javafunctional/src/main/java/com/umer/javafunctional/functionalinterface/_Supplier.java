package com.umer.javafunctional.functionalinterface;

public class _Supplier {
	
	private static final String DUMMY_DATABASE_CONNECTION_IRL = "jdbc://localhost:5432/users";

	public static void main(String[] args) {
		System.out.println(getDBConnectionUrl());
		
	}
	
	// declarative approach
	static String getDBConnectionUrl() {
		// A dummy database connection url
		return DUMMY_DATABASE_CONNECTION_IRL;
	}

}
