package com.test.hackerrank;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/30-2d-arrays
 *
 */
public class HourGlass {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        in.close();
        
        int maxSum = Integer.MIN_VALUE;
        for (int i=0 ; i<= arr.length-3; i++) {
        	for (int j=0; j<=arr[i].length-3; j++) {
        		int tempSum = arr[i][j] + arr[i][j+1] + arr[i][j+2] 
        				+ arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
//        		System.out.println(tempSum);
        		if (tempSum > maxSum) {
        			maxSum = tempSum;
        		}
        	}
        }
        System.out.println(maxSum);
	}

}
