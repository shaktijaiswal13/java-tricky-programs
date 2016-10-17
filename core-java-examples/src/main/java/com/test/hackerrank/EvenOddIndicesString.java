package com.test.hackerrank;

import java.util.Scanner;

public class EvenOddIndicesString {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        String[] stringArray = new String[testCases];
        for (int i=0; i<testCases; i++) {
            stringArray[i] = in.next();
        }
        in.close();
        
        for (int i=0; i<testCases; i++) {
            String str = stringArray[i];
            StringBuffer evenIndicesString = new StringBuffer();
            StringBuffer oddIndicesString = new StringBuffer();
            for (int j=0; j<str.length(); j++) {
                if (j % 2 == 0) {
                    evenIndicesString.append(str.charAt(j));
                } else {
                	oddIndicesString.append(str.charAt(j));
                }
            }
            System.out.println(evenIndicesString + " " + oddIndicesString);
        }
    }

}
