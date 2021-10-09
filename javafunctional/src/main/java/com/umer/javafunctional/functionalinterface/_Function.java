package com.umer.javafunctional.functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

	public static void main(String[] args) {
		// Function takes 1 argument and produces 1 result.
		int result = incrementByOneFunction(1);
		System.out.println("incrementByOneFunction using imperative approach: " + result);

		int result2 = incrementByOneFunction.apply(1);
		System.out.println("incrementByOneFunction using declarative approach: " + result2);

		int multiply = multiplyByTen.apply(result2);
		System.out.println("multiplyByTen using declarative approach: " + multiply);

		final Function<Integer, Integer> incrementByOneAndMultiplyByTen = 
				incrementByOneFunction.andThen(multiplyByTen);
		
		final Integer result3 = incrementByOneAndMultiplyByTen.apply(1);
		System.out.println("incrementByOneAndMultiplyByTen using declarative approach: " + result3);
		
		// BiFunction takes 2 argument and produces 1 result.
		final Integer result4 = incrementByOneAndMultiplyBiFunction.apply(4, 100);
		System.out.println("incrementByOneAndMultiplyBiFunction using declarative approach: " + result4);
		

	}

	// declarative approach
	static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

	static Function<Integer, Integer> multiplyByTen = number -> number * 10;

	// imperative approach
	static int incrementByOneFunction(int number) {
		return number + 1;
	}
	
	// declarative approach
	static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction=
			(numberToIncrement, numToMultiplyBy) -> (numberToIncrement + 1) * numToMultiplyBy; 
	
	
	// imperative approach
	static int incrementByOneAndMultiply(int number, int numToMultiplyBy) {
		return ((number + 1) * numToMultiplyBy);
	}

}
