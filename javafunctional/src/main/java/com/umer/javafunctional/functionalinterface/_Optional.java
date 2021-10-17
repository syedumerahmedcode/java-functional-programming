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
		
		System.out.println("---------------------------------------------------------------");
		System.out.println("Use case of optional.orElse");
		System.out.println("---------------------------------------------------------------");
		
		final Optional<String> hello2 = Optional.ofNullable(null);
		System.out.println(hello2.isPresent());
		System.out.println(hello2.isEmpty());
		final String world = hello2.orElse("World");
		System.out.println(world);
		
		System.out.println("++++++++++++++++");
		
		final Optional<String> hello3 = Optional.ofNullable("hello");
		System.out.println(hello3.isPresent());
		System.out.println(hello3.isEmpty());
		final String orElse = hello3
				.map(statement -> statement.toUpperCase())
				//.map(String::toUpperCase)---> Another way of writing map(statement -> statement.toUpperCase()) 
				.orElse("World");
		System.out.println(orElse);
		hello3.ifPresent(word ->{
			System.out.println("orginal world without modification: "+word);
		});
		hello3.ifPresentOrElse(word ->{
			System.out.println(word);
		}, () -> System.out.println("world"));
		
		System.out.println("++++++++++++++++");	
		
		final Optional<String> hello4 = Optional.ofNullable(null);
		System.out.println(hello4.isPresent());
		System.out.println(hello4.isEmpty());
		final String orElseGet = hello4
				.map(statement -> statement.toUpperCase())
				//.map(String::toUpperCase)---> Another way of writing map(statement -> statement.toUpperCase()) 
				.orElseGet(()->{
					//..the methods can contain some extra computation
					return "world";
				});
		System.out.println(orElseGet);
		hello4.ifPresentOrElse(word ->{
			System.out.println(word);
		}, () -> System.out.println("world"));
		
		
		System.out.println("---------------------------------------------------------------");
		System.out.println("How to handle optionalemail for a person");
		System.out.println("---------------------------------------------------------------");
		
		Person jamesHasEmailAddress=new Person("James", "james@some_email.com");
		final String emailOfJames = jamesHasEmailAddress
				.getEmail()
				.map(mapper ->mapper.toUpperCase())
				.orElse(jamesHasEmailAddress.getName() + " provided no e-mail address");
		System.out.println(emailOfJames
				);
		
		System.out.println("++++++++++++++++");	
		
		Person aliceHasNoEmailAddress=new Person("Alice", null);
		final String emailOfAlice = aliceHasNoEmailAddress
				.getEmail()
				.map(mapper ->mapper.toUpperCase())
				.orElse(aliceHasNoEmailAddress.getName() + " provided no e-mail address");
		System.out.println(emailOfAlice
				);

	}
}

class Person{
	private final String name;
	private final String email;
	
	public Person(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public Optional<String> getEmail() {
		return Optional.ofNullable(this.email);
	}


	
	
	
}
