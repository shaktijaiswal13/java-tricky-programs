package com.test.hackerrank.womenscodesprint2;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/womens-codesprint-2/challenges/electronics-shop
 *
 */
public class ElectronicsShop {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        int[] keyboards = new int[n];
        for(int keyboards_i=0; keyboards_i < n; keyboards_i++){
            keyboards[keyboards_i] = in.nextInt();
        }
        int[] pendrives = new int[m];
        for(int pendrives_i=0; pendrives_i < m; pendrives_i++){
            pendrives[pendrives_i] = in.nextInt();
        }
        in.close();
        
        int total = 0;
        for (int i=0; i<keyboards.length; i++) {
        	
        	for (int j=0; j<pendrives.length; j++) {
        		
        		int tempTotal = keyboards[i] + pendrives[j];
        		if (tempTotal <= s && total < tempTotal) {
        			total = tempTotal;
        		}
        	}
        }
        System.out.println("Total : " + total);
        if (total == 0) {
        	System.out.println("-1");
        } else {
        	System.out.println(total);
        }
	}

}
