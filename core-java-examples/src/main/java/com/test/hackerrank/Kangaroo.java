package com.test.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/kangaroo 
 * 4602 8519 7585 8362 (YES) 
 * 21 6 47 3 (NO)
 * 0 2 5 3 (NO)
 * 0 3 4 2 (YES)
 */
public class Kangaroo {

	public static void main(String[] args) throws InterruptedException {
		Scanner in = new Scanner(System.in);
		int x1 = in.nextInt();
		int v1 = in.nextInt();
		int x2 = in.nextInt();
		int v2 = in.nextInt();

		in.close();

		determineIfKangaroosMeet(x1, v1, x2, v2);
	}

	/**
	 * <pre>
	 * This method uses an efficient way of determining whether kangaroos meet or not.
	 * for eg: 0 3 4 2, x1=0, v1=3, x2=4, v2=2
	 * K1 = 0 -> 3 -> 6 -> 9 -> 12
	 * k2 = 4 -> 6 -> 8 -> 10 -> 12
	 * So K1 and K2 will meet at 12 after 4 jumps. So
	 * 0 + 4 * 3 = 12
	 * 4 + 4 * 2 = 12
	 * where '4' is the no of jumps and '12' is the position where kangaroos meet.
	 * This can be represented in equation as shown below:
	 * x1 + y * v1 = d
	 * x2 + y * v2 = d
	 * => x1 + y * v1 = x2 + y * v2
	 * => x2 - x1 = y * (v1 - v2)
	 * => (x2 - x1) / (v2 - v1) = y
	 * As per this equation, if we get a whole number after dividing the first part of the equation
	 * that means kangaroos will meet otherwise they will not meet at the same point. This is because
	 * 'y' represents the number of jumps which can only be a whole number (not having decimal part).
	 * So it can be concluded that if:
	 * (x2 - x1) % (v2 - v1) == 0,
	 * kangaroos will meet at the same position.
	 * </pre>
	 */
	private static void determineIfKangaroosMeet(int x1, int v1, int x2, int v2) {

		// The second kangaroo has a starting location that is ahead (further to
		// the right) of the first kangaroo's starting location (i.e., ). Because 
		// the second kangaroo moves at a faster rate (meaning )
		// and is already ahead of the first kangaroo, the first kangaroo will
		// never be able to catch up.
		if (x2 > x1 && v2 > v1) {
			System.out.println("NO");
		}
		// As second kangaroo will have a starting location that is ahead of the
		// first and if they both are
		// moving at the same rate, so they can never meet each other.
		else if (v1 == v2) {
			System.out.println("NO");
		} else if ((x2 - x1) % (v1 - v2) == 0) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	/**
	 * In this method, while loop is used to find out whether Kangaroos meet or
	 * not. This is not the right way, as it consist of looping through the
	 * values infinitely. which results in timeout after some time.
	 */
	private static void determineIfKangaroosMeet_wrongWay(int x1, int v1, int x2, int v2) {

		if (x2 > x1 && v2 > v1) {
			System.out.println("NO");
			return;
		} else if (v1 == v2) {
			System.out.println("NO");
			return;
		}
		// long kangaroo1Distance = x1;
		// long kangaroo2Distance = x2;
		//
		// while (kangaroo1Distance <= Long.MAX_VALUE && kangaroo2Distance <=
		// Long.MAX_VALUE) {
		// kangaroo1Distance += v1;
		// kangaroo2Distance += v2;
		// if (kangaroo1Distance == kangaroo2Distance) {
		// System.out.println(kangaroo1Distance + ", " + kangaroo2Distance);
		// System.out.println("YES");
		// return;
		// }
		// }

		BigInteger kangaroo1Distance = new BigInteger(x1 + "");
		BigInteger kangaroo2Distance = new BigInteger(x2 + "");
		int jumpCount = 0;
		while (kangaroo1Distance.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) != 1
				|| kangaroo2Distance.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) != 1) {
			kangaroo1Distance = kangaroo1Distance.add(BigInteger.valueOf(v1));
			System.out.println(kangaroo1Distance);
			kangaroo2Distance = kangaroo2Distance.add(BigInteger.valueOf(v2));
			System.out.println(kangaroo2Distance);
			jumpCount++;
			// Thread.sleep(500);
			if (kangaroo1Distance.equals(kangaroo2Distance)) {
				System.out.println(kangaroo1Distance + ", " + kangaroo2Distance);
				System.out.println("YES");
				System.out.println(jumpCount);
				return;
			}
		}
		System.out.println("NO");
	}
}
