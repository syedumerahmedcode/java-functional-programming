package com.umer.javafunctional.functionalinterface;

import java.util.Optional;

public class _Optional {

	public static void main(String[] args) {
		
		System.out.println("---------------------------------------------------------------");
		System.out.println("Use case of optional.empty");
		System.out.println("---------------------------------------------------------------");
		
		final Optional<Object> empty = Optional.empty();
		System.out.println("Current object is "+empty);
		System.out.println(empty.isPresent());
		System.out.println(empty.isEmpty());
		
		System.out.println("---------------------------------------------------------------");
		System.out.println("Use case of optional.of");
		System.out.println("---------------------------------------------------------------");
		
		final Optional<String> hello = Optional.of("hello");
		System.out.println(hello);
		System.out.println(hello.isPresent());
		System.out.println(hello.isEmpty());

	}
}
