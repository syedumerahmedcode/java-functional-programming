package com.umer.javafunctional.callback;

import java.util.function.Consumer;

public class Main {
	private static final String EMPTY_STRING = "  ";
	
	public static void main(String[] args) {
		
	
		System.out.println(EMPTY_STRING);
		System.out.println("------------------------------------------------------------");
		System.out.println("Last name is provided and Callback is null.");
		System.out.println("------------------------------------------------------------");
		hello("John", "Montana", null);
		System.out.println(EMPTY_STRING);
		
		System.out.println(EMPTY_STRING);
		System.out.println("------------------------------------------------------------");
		System.out.println("Last name is null and Callback is processing this condition.");
		System.out.println("------------------------------------------------------------");
		hello("John", null, value ->{
			System.out.println("No last name provided for "+value);
		});
		System.out.println(EMPTY_STRING);
		
		System.out.println(EMPTY_STRING);
		System.out.println("------------------------------------------------------------");
		System.out.println("Last name is null and Callback With Runnable is processing this condition.");
		System.out.println("------------------------------------------------------------");
		helloWithRunnable("John", null, ()->{
			System.out.println("No last name provided");
		});
		System.out.println(EMPTY_STRING);
		
	}
	
	
	static void hello(String firstName, String lastName, Consumer<String> callback) {
		System.out.println(firstName);
		if(lastName!=null) {
			System.out.println(lastName);
		}else {
			callback.accept(firstName);
		}
	}
	
	static void helloWithRunnable(String firstName, String lastName, Runnable callback) {
		System.out.println(firstName);
		if(lastName!=null) {
			System.out.println(lastName);
		}else {
			callback.run();
		}
	}
	
	
	/**
	 * Sample java script code which does callback()
	 */
//	function hello(firstName, lastName, callback) {
//		console.log(firstName);
//		if(lastName) {
//			console.log(lastName);
//		}else {
//			callback();
//		}
//	}

}
