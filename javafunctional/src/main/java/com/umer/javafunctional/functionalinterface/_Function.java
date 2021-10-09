package com.umer.javafunctional.functionalinterface;

import java.util.function.Function;

public class _Function {
	
	public static void main(String[] args) {
		int result = incrementByOne(1);
		System.out.println(result);
		
		int result2=incrementByOneFunction.apply(1);
		System.out.println(result2);
	}
	
	// declarative approach
	static Function<Integer, Integer> incrementByOneFunction=number -> number+1;
	
	// imperative approach
	static int incrementByOne(int number) {
		return number+1;
	}

}
