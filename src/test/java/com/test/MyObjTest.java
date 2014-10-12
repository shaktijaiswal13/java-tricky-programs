package com.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MyObjTest {

	private MyObj myObj;

	@BeforeClass
	public static void beforeClass() {
		System.err.println("beforeClass called");
	}

	@Before
	public void setUp() {
		System.err.println("setUp called");
		myObj = new MyObj("hi");
	}

	@After
	public void tearDown() {
		System.err.println("tearDown called");
	}

	@Test
	public void addNumberTest() {
		System.err.println("addNumberTest called");
		int result = myObj.addNumber(10, 20);
		Assert.assertEquals("Should be equal.", 30, result);
	}

	@Test
	public void addNumberTest1() {
		System.err.println("addNumberTest1 called");
		int result = myObj.addNumber(20, 20);
		Assert.assertEquals("Should be equal.", 40, result);
	}
}
