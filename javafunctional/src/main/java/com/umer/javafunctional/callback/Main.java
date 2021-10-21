package com.umer.javafunctional.callback;

import java.util.function.Consumer;

public class Main {
	
	public static void main(String[] args) {
		/**
		 * Last name is provided and Callback is null
		 */
		hello("John", "Montana", null);
	}
	
	
	static void hello(String firstName, String lastName, Consumer<String> callback) {
		System.out.println(firstName);
		if(lastName!=null) {
			System.out.println(lastName);
		}else {
			callback.accept(firstName);
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
