package com.umer.javafunctional.streams;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.*;

public class Sample {
	private static final String EMPTY_STRING = "  ";

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		// given the numbers, double the even numbers and total
		
		int result=0;
		for(int e: numbers) {
			if(e%2==0) {
				result+=e*2;
			}
		}		
		System.out.println(EMPTY_STRING);
		System.out.println("--------------------------------------");
		System.out.println("The end result with imperative approach is: "+result);
		System.out.println("--------------------------------------");
		System.out.println(EMPTY_STRING);
		
		System.out.println(EMPTY_STRING);
		System.out.println("--------------------------------------");
		System.out.println("The end result with declarative approach is: "+
				numbers.stream()
				.filter(e -> e%2==0)
				.map(e -> e*2)
				.reduce(0, Integer::sum));
		System.out.println("--------------------------------------");
		System.out.println(EMPTY_STRING);
		System.out.println(EMPTY_STRING);
		System.out.println("--------------------------------------");
		TimeIt.code(()->
		System.out.println("The end result with declarative approach plus call of method is: "+
				numbers.stream()
				.filter(e -> e%2==0)
				.mapToInt(e -> Sample.compute(e))
				.sum())
		);
		System.out.println("--------------------------------------");
		System.out.println(EMPTY_STRING);
		System.out.println(EMPTY_STRING);
		System.out.println("--------------------------------------");
		TimeIt.code(()->
		System.out.println("The end result with declarative approach WITH PARALLEL STREAM plus call of method is: "+
				numbers.parallelStream()
				.filter(e -> e%2==0)
				.mapToInt(e -> Sample.compute(e))
				.sum())
		);
		System.out.println("--------------------------------------");
		System.out.println(EMPTY_STRING);
		System.out.println(EMPTY_STRING);
		System.out.println("--------------------------------------");
		List<Integer> doubleOfEven=numbers.stream()
				.filter(e ->e%2==0)
				.map(e -> e*2)
				.collect(toList());
		System.out.println("The double of even numbers from the list using collect() method is: "+doubleOfEven);
		System.out.println("--------------------------------------");
		System.out.println(EMPTY_STRING);
										
		
		
	}
	
	public static int compute(int number) {
		// assume this is a time intensive operation
		try {
			Thread.sleep(1000);
		}catch(Exception ex) {
			// skipped as we are not doing anything and keeping the example simple.
		}
		return number *2;
		
	}

}
