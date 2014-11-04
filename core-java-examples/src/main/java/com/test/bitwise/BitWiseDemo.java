package com.test.bitwise;

public class BitWiseDemo {
	public static void main(final String[] args) {
		System.err.println((char) ('A' | ' '));// lowercase
		System.err.println((char) ('a' | ' '));// lowercase
		System.err.println((char) ('a' & '_'));// uppercase
		System.err.println((char) ('A' & '_'));// uppercase
		System.err.println((char) ('A' ^ ' '));// invert letter
	}
}
