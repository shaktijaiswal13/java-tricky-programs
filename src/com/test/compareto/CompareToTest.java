package com.test.compareto;

import java.util.HashSet;
import java.util.TreeSet;

public class CompareToTest {

	public static void main(String[] args) {
		Student s1 = new Student(10, "Amar");
		Student s2 = new Student(11, "amar");

		System.err.println(s1.compareTo(s2));

		HashSet<Student> set = new HashSet<>();
		set.add(s1);
		set.add(s2);
		System.err.println(set.size());

		TreeSet<Student> treeSet = new TreeSet<>(/*
												 * new Comparator<Student>() {
												 * 
												 * @Override public int
												 * compare(Student o1, Student
												 * o2) { // TODO Auto-generated
												 * method stub return o1.getId()
												 * == o2.getId() ? 0 :
												 * o1.getId() > o2.getId() ? 1 :
												 * -1; }
												 * 
												 * }
												 */);
		treeSet.add(s1);
		treeSet.add(s2);
		System.err.println(treeSet.size());
	}
}

class Student implements Comparable<Student> {
	private final int id;

	public int getId() {
		return id;
	}

	private final String name;

	Student(int id, String name) {
		this.id = id;
		this.name = name;
	}

	// @Override
	@Override
	public int compareTo(Student stu) {
		int nameDiff = name.compareToIgnoreCase(stu.name);
		if (nameDiff != 0) {
			return nameDiff;
		}
		return this.id == stu.id ? 0 : this.id > stu.id ? 1 : -1;
	}
}