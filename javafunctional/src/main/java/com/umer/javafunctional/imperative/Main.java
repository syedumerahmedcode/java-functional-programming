package com.umer.javafunctional.imperative;

import java.util.List;
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
