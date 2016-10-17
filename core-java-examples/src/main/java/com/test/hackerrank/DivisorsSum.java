package com.test.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/30-interfaces
 * For an integer N, return the sum of all its divisors. 1 <= N <= 1000.
 * Input: 16, output: 31
 * Input: 6, output: 12
 * Input: 1, output: 1
 * Input: 20, output: 42
 * Input: 135, output: 240
 */
public class DivisorsSum {

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        
      	AdvancedArithmetic myCalculator = new Calculator(); 
        int sum = myCalculator.divisorSum(n);
        System.out.println("\nI implemented: " + myCalculator.getClass().getInterfaces()[0].getName() );
        System.out.println(sum);
    }

}

interface AdvancedArithmetic{
	int divisorSum(int n);
}

class Calculator implements AdvancedArithmetic{

	@Override
	public int divisorSum(int n) {
		
		if (n == 1) {
			return 1;
		}
		
		int divisor = 1;
		int quotient = n;
		int sum = divisor + quotient;
		System.out.print("Divisors are: " + divisor + " " + quotient + " ");
		
		// run loop till n/2 because after that there is only one divisor the number itself.
		for (divisor = 2; divisor <= n/2; divisor++) {
			
			// if we have already find all the divisors, e.g. for 28 factors are,
			// 1x28, 2x14, 4x7 and then in reverse order,
			// 7x4, 14x2, 28x1
			// as the quotient in 4x7 i.e., 7, is equal to the divisor in 7x4 i.e., 7,
			// so we can determine that this is the last factor.
			if (divisor == quotient) {
				break;
			}
			if (n % divisor == 0) {
				
				quotient = n / divisor;
				System.out.print(divisor + " " + quotient + " ");
				
				// if divisor and quotient are same. for 9, we have factors 
				// 1x9, 3x3, 9x1
				// as 3 is same for divisor and quotient in 3x3, we can determine that this is the last factor.
				if (quotient == divisor) {
					sum += divisor;
					break;
				}
				// adding quotient to divisor, as quotient will be divisor when the factors are repeated in 
				// reverse order (see examples above). So discarding the unnecessary looping.
				sum += divisor + quotient;
			}
			// if there is no other number between the divisor and quotient, e.g.
			// for 20, we have factors 
			// 1x20, 2x10, 4x5 and then in reverse order,
			// 5x4, 10x2, 20x1
			// as there is no other no between 4x5, we can determine that this is the last factor.
			if ((quotient - divisor == 1)) {
				break;
			}
		}
		
		return sum;
	}
	
}
