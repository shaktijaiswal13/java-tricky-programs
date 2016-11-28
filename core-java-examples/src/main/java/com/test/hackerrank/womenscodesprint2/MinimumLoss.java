package com.test.hackerrank.womenscodesprint2;

import java.util.Scanner;

public class MinimumLoss {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
        int noOfYears = scan.nextInt();
        long[] housePrices = new long[noOfYears];
        for(int i=0; i < noOfYears; i++){
        	housePrices[i] = scan.nextLong();
        }
        scan.close();
        
        long actualLoss = 0;
        for (int i=0; i < housePrices.length; i++) {
        	for (int j=i+1; j < housePrices.length; j++) {
        		if (housePrices[i] > housePrices[j]) {
        			long tempLoss = housePrices[i] - housePrices[j];
        			if (actualLoss > tempLoss || actualLoss == 0) {
        				actualLoss = tempLoss;
        			}
        		}
        	}
        }
        System.out.println(actualLoss);
	}

}
