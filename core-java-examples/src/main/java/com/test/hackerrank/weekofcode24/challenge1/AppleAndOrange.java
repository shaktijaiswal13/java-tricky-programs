package com.test.hackerrank.weekofcode24.challenge1;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/w24/challenges/apple-and-orange
 *
 */

public class AppleAndOrange {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long houseStartPoint = in.nextLong();
        long houseEndPoint = in.nextLong();
        long appleTreeLocation = in.nextLong();
        long orangeTreeLocation = in.nextLong();
        int noOfApplesFallen = in.nextInt();
        int noOfOrangesFallen = in.nextInt();
        
        long[] fallenApplesDistances = new long[noOfApplesFallen];
        for(int apple_i=0; apple_i < noOfApplesFallen; apple_i++){
        	fallenApplesDistances[apple_i] = in.nextInt();
        }
        
        long[] fallenOrangesDistances = new long[noOfOrangesFallen];
        for(int orange_i=0; orange_i < noOfOrangesFallen; orange_i++){
        	fallenOrangesDistances[orange_i] = in.nextInt();
        }
        in.close();
        
        long applesFallenOnHouse = 0;
        for (int i=0; i < fallenApplesDistances.length; i++) {
        	long appleDistance = fallenApplesDistances[i];
        	if (appleDistance > 0) {
        		long fallenAppleLocation = appleTreeLocation + appleDistance;
        		// fallen apple location should be between houseStartPoint and houseEndPoint
        		if (fallenAppleLocation >= houseStartPoint && fallenAppleLocation <= houseEndPoint) {
        			applesFallenOnHouse++;
        		}
        	}
        }
        
        long orangesFallenOnHouse = 0;
        for (int i=0; i < fallenOrangesDistances.length; i++) {
        	long orangeDistance = fallenOrangesDistances[i];
        	if (orangeDistance < 0) {
        		long fallenOrangeLocation = orangeTreeLocation + orangeDistance;
        		// fallen orange location should be between houseStartPoint and houseEndPoint
        		if (fallenOrangeLocation >= houseStartPoint && fallenOrangeLocation <= houseEndPoint) {
        			orangesFallenOnHouse++;
        		}
        	}
        }
        
        System.out.println(applesFallenOnHouse);
        System.out.println(orangesFallenOnHouse);
    }

}
