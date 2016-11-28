package com.test.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/beautiful-days-at-the-movies
 *
 */
public class BeautifulDaysAtTheMovies {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int firstValue = scan.nextInt();
		int lastValue = scan.nextInt();
		int divisor = scan.nextInt();
		scan.close();
		
		int beautifulDaysCount = 0;
		
		for (int i=0; i <= lastValue-firstValue; i++) {
			int nextValue = firstValue + i;
			String firstValueString = String.valueOf(nextValue);
			StringBuffer temp = new StringBuffer();
			for (int j=firstValueString.length()-1; j>=0; j--) {
				temp.append(firstValueString.charAt(j));
			}
			int firstValueReversed = Integer.parseInt(temp.toString());
			System.out.println("firstValue: " + (nextValue) + ", firstValueReversed:" + firstValueReversed);
			System.out.println("Difference: " + (nextValue - firstValueReversed) + ", remainder:" + ((nextValue - firstValueReversed) % divisor));
			if ((nextValue - firstValueReversed) % divisor == 0) {
				beautifulDaysCount++;
				System.out.println("beautifulDaysCount incremented:" + beautifulDaysCount);
			}
		}
		System.out.println(beautifulDaysCount);
	}

}
