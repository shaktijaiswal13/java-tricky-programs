package com.test.hackerrank.codesprint7.challenge1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class SockMerchant {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfSocks = in.nextInt();
        int socksColours[] = new int[numberOfSocks];
        for(int c_i=0; c_i < numberOfSocks; c_i++){
            socksColours[c_i] = in.nextInt();
        }
        in.close();
        int numberOfSocksToSell = 0;
        Map<Integer, Integer> sockColourCountMap = new HashMap<>();
        
        for (int i=0; i<socksColours.length; i++) {
        	int sockColour = socksColours[i];
        	if (sockColourCountMap.containsKey(sockColour)) {
        		int sockColourCount = sockColourCountMap.get(sockColour);
        		sockColourCountMap.put(sockColour, ++sockColourCount);
        	} else {
        		sockColourCountMap.put(sockColour, 1);
        	}
        }
        for (Integer sockColourCount : sockColourCountMap.values()) {
        	numberOfSocksToSell += sockColourCount / 2;
        }
        System.out.println(numberOfSocksToSell);
    }

}
