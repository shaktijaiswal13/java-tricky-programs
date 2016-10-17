package com.test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.text.AbstractDocument.LeafElement;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static String warGameWinner(int[] player1Deck, int[] player2Deck) {

		Queue<Integer> player1Queue = new LinkedList<>();
		for (Integer val : player1Deck) {
			player1Queue.add(val);
		}
		Queue<Integer> player2Queue = new LinkedList<>();
		for (Integer val : player2Deck) {
			player2Queue.add(val);
		}
		int noOfTurns = 0;
		while (player1Queue.size() != 0 && player2Queue.size() != 0) {
			Integer player1Card = player1Queue.peek();
			Integer player2Card = player2Queue.peek();
			if (player1Card.compareTo(player2Card) > 0) {
				player1Queue.add(player1Queue.poll());
				player1Queue.add(player2Queue.poll());
			} // Assuming there is no duplication
			else {
				player2Queue.add(player2Queue.poll());
				player2Queue.add(player1Queue.poll());
			}
			noOfTurns++;

		}
		if (player1Queue.size() != 0) {
			return "1" + noOfTurns;
		} else {
			return "2" + noOfTurns;
		}
	}
}
