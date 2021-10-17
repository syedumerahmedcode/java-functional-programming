package com.umer.javafunctional.functionalinterface;

import java.util.Optional;

public class _Optional {

	public static void main(String[] args) {
		
		final Optional<Object> empty = Optional.empty();
		System.out.println("Current object is "+empty);
		System.out.println(empty.isPresent());
		System.out.println(empty.isEmpty());
		

	}
}
