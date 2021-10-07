package com.umer.javafunctional.imperative;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.umer.javafunctional.imperative.Main.Gender.*;

public class Main {
	public static void main(String[] args) {
		List<Person> people = List.of(
				new Person("Umer", MALE), 
				new Person("Maria", FEMALE),
				new Person("Aisha", FEMALE), 
				new Person("Alex", MALE), 
				new Person("Alice", FEMALE)
			);

		System.out.println("// Imperative approach");
		List<Person> females = new ArrayList<Main.Person>();
		for (Person person : people) {
			if (FEMALE.equals(person.gender)) {
				females.add(person);
			}
		}
		
		for (Person female: females) {
			System.out.println(female);
		}
		
		System.out.println("// Declarative approach");
		people.stream()
				.filter(person ->FEMALE.equals(person.gender))
				//.collect(Collectors.toList())
				.forEach(System.out:: println);
		

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
		MALE, FEMALE;
	}
}
