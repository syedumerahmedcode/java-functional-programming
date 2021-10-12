package com.umer.javafunctional.streams;


import java.util.List;


public class _Stream {
	
	public static void main(String[] args) {
		List<Person> people = List.of(
				new Person("Umer", Gender.MALE), 
				new Person("Maria", Gender.FEMALE),
				new Person("Aisha", Gender.FEMALE), 
				new Person("Alex", Gender.MALE), 
				new Person("Alice", Gender.FEMALE)
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
