package com.test.iterator;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

public class IteratorTest {

	public static void main(String[] args) {
		new HashMap<>();
		new ArrayList<>();
		LinkedList<String> linkList = new LinkedList<String>();
		linkList.add("First");
		linkList.add("Second");
		linkList.add("Third");
		linkList.add("Fourth");
		linkList.add("Fifth");

		Iterator<String> linkListIterator = linkList.iterator();
		while(linkListIterator.hasNext()) {
			String str = linkListIterator.next();
			//System.out.println(str);
			if (str.equals("Third")) {
				linkListIterator.remove();
//				linkList.remove();		//this will throw java.util.ConcurrentModificationException
			}
		}
		
		for (String linkListEle : linkList) {
			System.out.println(linkListEle);
		}
		
		Hashtable<String, String> hashTable = new Hashtable<>();
		hashTable.put("One", "1");
		hashTable.put("Two", "2");
		hashTable.put("Three", "3");
		hashTable.put("Four", "4");
		hashTable.put("Five", "5");

		Enumeration<String> enumerator = hashTable.keys();
		while (enumerator.hasMoreElements()) {
			String key = enumerator.nextElement();
			String value = hashTable.get(key);
			System.out.println(key + ", " + value);
			hashTable.remove(key);
		}
		
		Enumeration<String> enumerator1 = hashTable.keys();
		System.out.println(enumerator1.hasMoreElements());
		
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("Six", "6");
		hashMap.put("Seven", "7");
		hashMap.put("Eight", "8");
		hashMap.put("Nine", "9");
		hashMap.put("Ten", "10");
		
		Iterator<String> itr = hashMap.keySet().iterator();
		while (itr.hasNext()) {
			String key = itr.next();
			String value = hashMap.get(key);
			System.out.println(key + ", " + value);
			itr.remove();
//			hashMap.remove(key);		//this will throw java.util.ConcurrentModificationException
		}
		Iterator<String> itr1 = hashMap.keySet().iterator();
		System.out.println(itr1.hasNext());

	}
}
