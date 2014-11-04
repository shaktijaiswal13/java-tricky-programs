package com.test.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	/*
	 * ArrayLIst is Resizable-array implementation of the List interface. Each
	 * ArrayList instance has a capacity. The capacity is the size of the array
	 * used to store the elements in the list. It is always at least as large as
	 * the list size. As elements are added to an ArrayList, its capacity grows
	 * automatically. The details of the growth policy are not specified beyond
	 * the fact that adding an element has constant amortized time cost. As per
	 * JDK7 capacity of linked list increases as (oldCapacity + (oldCapacity >>
	 * 1)) when arraylist has elements equal to the oldCapacity.
	 */
	public static void main(String[] args) {
		List arrayList = new ArrayList<>(2);

		System.err.println("arrayList.size(): " + arrayList.size());
		System.err.println("arrayList.isEmpty(): " + arrayList.isEmpty());

		arrayList.add(1);
		arrayList.add(2);

		System.err.println("arrayList.size(): " + arrayList.size());
		System.err.println("arrayList.isEmpty(): " + (arrayList.size() >> 1));

		arrayList.add(3);

		System.err.println("arrayList.size(): " + arrayList.size());
		System.err.println("arrayList.isEmpty(): " + (arrayList.size() >> 1));

		arrayList.add(4);

		System.err.println("arrayList.size(): " + arrayList.size());
		System.err.println("arrayList.isEmpty(): " + (arrayList.size() >> 1));

		arrayList.add(5);
		arrayList.add(6);
		arrayList.add(7);

		System.err.println("arrayList.size(): " + arrayList.size());
		System.err.println("arrayList.isEmpty(): " + (arrayList.size() >> 1));

		arrayList.add(8);
		arrayList.add(9);
		arrayList.add(10);
		arrayList.add(11);

		System.err.println("arrayList.size(): " + arrayList.size());
		System.err.println("arrayList.isEmpty(): " + (arrayList.size() >> 1));
	}
}
