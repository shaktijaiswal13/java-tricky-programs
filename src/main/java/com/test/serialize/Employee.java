package com.test.serialize;

public class Employee extends MyObj implements java.io.Serializable {

	public Employee(String a) {

		super(a);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// public transient String a;
	public String name;
	public String address;
	public transient int SSN;
	public Integer number;
	int t;

	public void mailCheck() {
		System.out.println("Mailing a check to " + name + " " + address);
	}
}