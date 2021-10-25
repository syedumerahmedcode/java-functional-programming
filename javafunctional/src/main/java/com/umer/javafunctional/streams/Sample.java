package com.umer.javafunctional.streams;

import java.util.Arrays;
import java.util.List;

public class Sample {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		// given the numbers, double the even numbers and total
		
		int result=0;
		for(int e: numbers) {
			if(e%2==0) {
				result+=e*2;
			}
		}		
		System.out.println("The end result with imperative approach is: "+result);
		
		System.out.println("The end result with declarative approach is: "+
				numbers.stream()
				.filter(e -> e%2==0)
				.map(e -> e*2)
				.reduce(0, Integer::sum));
		
		
		System.out.println("The end result with declarative approach plus call of method is: "+
				numbers.stream()
				.filter(e -> e%2==0)
				.mapToInt(e -> Sample.compute(e))
				.sum());
		
		
	}
	
	public static int compute(int number) {
		// assume this is a time intensive operation
		return number *2;
		
	}

}
