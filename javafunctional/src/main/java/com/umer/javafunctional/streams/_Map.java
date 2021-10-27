package com.umer.javafunctional.streams;

import java.util.Arrays;
import java.util.List;

import com.umer.javafunctional.streams._Stream.Gender;
import com.umer.javafunctional.streams._Stream.Person;
import static java.util.stream.Collectors.*;

public class _Map {
	
	public static List<Person> createPeople(){
		return Arrays.asList(
				new Person("Bob", Gender.MALE),
				new Person("Alice", Gender.FEMALE),
				new Person("Sara", Gender.FEMALE),
				new Person("Claire", Gender.FEMALE),
				new Person("Tom", Gender.MALE),
				new Person("John", Gender.MALE),
				new Person("Smith", Gender.MALE)				
				);		
	}
	
	public static void main(String[] args) {
		List<Person> people=createPeople();
		
		// create a map with name as key, and person as value.
		System.out.println(
		people.stream()
			.collect(toMap(
					person -> person.getName(), 
					person -> person)
					));
		
	}

}
