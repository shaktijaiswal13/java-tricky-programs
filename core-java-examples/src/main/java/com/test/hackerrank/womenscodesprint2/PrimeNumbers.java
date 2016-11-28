package com.test.hackerrank.womenscodesprint2;

import java.util.Scanner;

public class PrimeNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		boolean isPrime = true;
		if (n % 2 != 0) {
			int i = 3;
			while (i < n/2) {
				if (n % i == 0) {
					isPrime = false;
					break;
				} else {
					i++;
				}
			}
		} else {
			isPrime = false;
		}
		if (isPrime) {
			System.out.println(n +  " is prime.");
		} else {
			System.out.println(n +  " is not prime.");
		}
	}

}
