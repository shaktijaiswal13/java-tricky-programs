package com.test.testdome.tests;

import java.math.BigInteger;

public class Frog {
    public static long numberOfWays(int n) {
    	long totalWays = 1;
    	int noOfSteps = n;
    	int noOfJumps = 0;
    	
    	while (noOfSteps >= 2) {
    		System.out.println("value is: " + n);
    		noOfSteps = n - (2 * ++noOfJumps);
    		System.out.println("noOfSteps: " + noOfSteps);
    		System.out.println("noOfJumps: " + noOfJumps);
    		
    		totalWays += calcuateTotalWays(noOfSteps, noOfJumps);
    		
    		//totalWays += calcuateFcatorial(noOfSteps + noOfJumps) / 
    		//		(calcuateFcatorial(noOfSteps) * calcuateFcatorial(noOfJumps));
    		
    		//totalWays += calcuateFcatorialWithRecursion(noOfSteps + noOfJumps) / 
    		//		(calcuateFcatorialWithRecursion(noOfSteps) * calcuateFcatorialWithRecursion(noOfJumps));
    		
    		System.out.println("totalWays: " + totalWays);
    	} ;
    	return totalWays;
    }
    
    private static long calcuateTotalWays(int noOfSteps, int noOfJumps) {
    	
    	if (noOfSteps == 0) {
    		return 1;
    	}
    	BigInteger total = new BigInteger("1");
    	BigInteger finalValue = new BigInteger("1");
    	int noOfStepsJumps = noOfSteps + noOfJumps;
    	
    	for (int i=0; i < noOfJumps; i++) {
    		
    		total = total.multiply(BigInteger.valueOf(noOfStepsJumps - i));
    		finalValue = finalValue.multiply(BigInteger.valueOf(noOfJumps - i));
    		
    		/*if (total.mod(finalValue) != BigInteger.ZERO) {
    			continue;
    		} else {
    			total = total.divide(finalValue);
    			finalValue = BigInteger.valueOf(1);
    		}*/
    	}
		total = total.divide(finalValue);

    	System.out.println("Total in calcuateTotalWays: " + total.toString());
    	return total.longValue();
    }

    public static void main(String[] args) {
        System.out.println(numberOfWays(1));
        System.out.println(numberOfWays(2));
        System.out.println(numberOfWays(3));
        System.out.println(numberOfWays(4));
        System.out.println(numberOfWays(5));
        System.out.println(numberOfWays(10));
        System.out.println(numberOfWays(50));
        System.out.println(numberOfWays(500));

        //System.out.println(calcuateFcatorial(10));
        //System.out.println(calcuateFcatorial(7));
    }
    
    private static int calcuateFcatorialWithRecursion(int number) {
    	if (number == 0 || number == 1) {
    		return 1;
    	}
    	return (number * calcuateFcatorialWithRecursion(number - 1));
    }
    
    private static int calcuateFcatorial(int number) {
    	System.out.println("number:" + number);
    	if (number == 0 || number == 1) {
    		return 1;
    	}
    	int total = 1;
    	for (int i=2; i<=number; i++) {
    		total *= i;
    	}
    	return total;
    }
    
    private static int calcuateTotalWaysUsingInt(int noOfSteps, int noOfJumps) {
    	int total = 1;
    	int finalValue = 1;
    	
    	for (int i=0; i<noOfJumps; i++) {
    		total *= (noOfSteps + noOfJumps - i);
    		finalValue *= (noOfJumps - i);
    		if (total % finalValue != 0) {
    			continue;
    		} else {
    			total = total / finalValue;
    			finalValue = 1;
    		}
    	}
    	return total;
    }
}