/**
 * 
 */
package com.example.demo;

/**
 * 
 */
public record Person(
		String firstName, 
		String lastName, 
		String nationalCode) 
		implements Comparable<Person>{
	
	
	public Person {
		// TODO Auto-generated constructor stub	
		if (nationalCode.length() != 10)
			System.out.println("National code validation Exception");
	}
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return this.lastName.compareTo(o.firstName());
	}
	
};