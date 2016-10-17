package com.test.hackerrank;

import java.text.DecimalFormat;
import java.util.Scanner;

public class DataTypesTest {

	public static void main(String[] args) {

		int i = 4;
        double d = 4.0;
        String s = "HackerRank ";
		
        Scanner scan = new Scanner(System.in);
        scan.useDelimiter("\\n");
        
        /* Declare second integer, double, and String variables. */
        int secondInt;
        double secondDub;
        String secondStr;

        /* Read and save an integer, double, and String to your variables.*/
        //System.out.println("Enter an integer value:");
        secondInt = scan.nextInt();

        //System.out.println("Enter a double value:");
        secondDub = scan.nextDouble();

        //System.out.println("Enter a string:");
        secondStr = scan.next();

        /* Print the sum of both integer variables on a new line. */
        System.out.println(i + secondInt);

        /* Print the sum of the double variables on a new line. */
        DecimalFormat format = new DecimalFormat("#0.0");
		System.out.println(format.format(d + secondDub));
		
        /* Concatenate and print the String variables on a new line; 
        	the 's' variable above should be printed first. */
        System.out.println(s + secondStr);
        
        //
        System.out.println(scan.nextLine());
        System.out.println(scan.nextLine());
        System.out.println(scan.nextLine());


        scan.close();
	}

}
