package com.test.multicatchblock;

import java.io.IOException;
import java.util.Scanner;

public class MultiCatchBlockTest {

	public static void main(String args[]) {
		Scanner scnr = new Scanner(System.in);
		String number = scnr.next();
		try {
			if (number.length() > 5) {
				throw new IOException();
			}
			Integer.parseInt(number);

		} catch (NumberFormatException | IOException | IndexOutOfBoundsException e) {
			System.out.println("in catch block");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println("in catch block");
			e.printStackTrace();
		} //catch (NumberFormatException | IllegalArgumentException e) {} it is compile time error to have child and parent togther in OR clause.
		
	}

	// Read more:
	// http://javarevisited.blogspot.com/2011/07/jdk7-multi-cache-block-example-tutorial.html#ixzz3CpkNwhsU
}
