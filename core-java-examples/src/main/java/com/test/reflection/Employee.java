package com.test.reflection;

public class Employee {

	private String name;
	public int salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public String getName() {
		return name;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public static void print() {
		System.out.println("Inside Employee class");
	}
}
