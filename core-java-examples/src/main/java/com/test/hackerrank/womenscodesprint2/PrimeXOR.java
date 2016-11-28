package com.test.hackerrank.womenscodesprint2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeXOR {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int noOfQueries = in.nextInt();
		int[][] integerArray = new int[noOfQueries][];

		for (int i = 0; i < noOfQueries; i++) {
			int noOfIntegers = in.nextInt();
			integerArray[i] = new int[noOfIntegers];
			for (int j = 0; j < noOfIntegers; j++) {
				integerArray[i][j] = in.nextInt();
			}
		}
		in.close();

		List<Integer> oddNumbersList = new ArrayList<>();
		List<Integer> evenNumbersList = new ArrayList<>();
		List<Integer> primeNumbersList = new ArrayList<>();

		for (int i = 0; i < integerArray.length; i++) {
			generateOddEvenNumbersList(integerArray[i], oddNumbersList, evenNumbersList);
			generatePrimeNumbersList(oddNumbersList, primeNumbersList);
			System.out.println(primeNumbersList.size());
		}
	}

	private static void generatePrimeNumbersList(List<Integer> oddNumbersList, List<Integer> primeNumbersList) {
		for (Integer number : oddNumbersList) {
			
			boolean isPrime = true;
			int i = 3;
			while (i < number/2) {
				if (number % i == 0) {
					isPrime = false;
					break;
				} else {
					i++;
				}
			}
			if (isPrime) {
				primeNumbersList.add(number);
			}
		}
	}

	private static void generateOddEvenNumbersList(int[] integerArray, List<Integer> oddNumbersList,
			List<Integer> evenNumbersList) {
		for (int j = 0; j < integerArray.length; j++) {
			int intElement = integerArray[j];
			if (intElement % 2 == 0) {
				evenNumbersList.add(intElement);
			} else {
				oddNumbersList.add(intElement);
			}
		}
	}

}
