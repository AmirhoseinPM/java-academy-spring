package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestSpringStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSpringStarterApplication.class, args);
		
		System.out.println("Somethings about Record DataType in java");
		
		Person person = new Person("amirhosein", "pooyan", "0123456789");
		System.out.println("Recorn toString(): " + person);
		
		Person person2 = new Person("amirhosein", "pooyan", "0123456789");		
		System.out.println( 
				"Records with same field values are equals? " + 
				person.equals(person2));		
		
		var person3 = new Person("naser", "abdollahi", "0123456789");		
		var persons = new ArrayList<Person>();
		persons.addAll(Arrays.asList(person, person2, person3));
		
		System.out.println("Unsorted List: " + persons);
		Collections.sort(persons);
		System.out.println("Sorted List: " + persons);
		
		System.out.println("nationalcode fild validate: ");
		var p = new Person("gholam", "abbasi", "012");
	}

}
