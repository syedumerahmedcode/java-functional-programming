package com.umer.javafunctional.streams;


import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;


public class _Stream {
	
	public static void main(String[] args) {
		List<Person> people = List.of(
				new Person("Umer", Gender.MALE), 
				new Person("Maria", Gender.FEMALE),
				new Person("Aisha", Gender.FEMALE), 
				new Person("Alex", Gender.MALE), 
				new Person("Alice", Gender.FEMALE),
				new Person("Bob", Gender.PREFER_NOT_TO_SAY)
			);
		
		System.out.println("--------------------------------------");
		System.out.println("Displaying gender of people");
		System.out.println("--------------------------------------");
		
		people.stream()
				.map(person -> person.gender)// Converting the Person just to their gender
				.collect(Collectors.toSet())// Removing duplicates
				.forEach(gender -> System.out.println(gender));// printing the list of gender in the set
		
		System.out.println("--------------------------------------");
		System.out.println("Displaying names of people");
		System.out.println("--------------------------------------");
		
		people.stream()
				.map(person -> person.name)
				.collect(Collectors.toSet())
				.forEach(name -> System.out.println(name));
		
		System.out.println("--------------------------------------");
		System.out.println("Displaying length of each name in order of the input people list");
		System.out.println("--------------------------------------");
		
		final Function<? super Person, ? extends String> function = person -> person.name;
		final IntConsumer intConsumer = length -> System.out.println(length);
		people.stream()
				.map(function)
				.mapToInt(name -> name.length())		
				.forEach(intConsumer);
		
	}
	
	static class Person {
		private final String name;
		private final Gender gender;

		public Person(String name, Gender gender) {
			this.name = name;
			this.gender = gender;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Person {" + "name='" + name + "\'" + ", gender=" + gender + "}";

		}
	}

	enum Gender {
		MALE, FEMALE, PREFER_NOT_TO_SAY;
	}

}
