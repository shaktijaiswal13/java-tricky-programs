package com.test.immutable;

import java.util.Date;

/**
 * 
 * @author shaktikumar
 *
 */

public  class Person {
	private final String name;
	private final Integer age;
	private final Date dob;

	public Person(String name, Integer age, Date dob) {
		this.name = name;
		this.age = age;
		this.dob = (Date) dob.clone();
	}

	public Integer getAge() {
		return age;
	}

	public String getName() {
		return name;
	}
	public static void main(String[] args) {
		Date dob2 = new Date();
		
		Person person=new  Person("sds", 12, dob2);
		System.err.println(person);
		dob2.setDate(12);
		System.err.println(person);
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", dob=" + dob + "]";
	}
	
}
