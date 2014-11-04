package com.test.classloaders;

import java.lang.ref.PhantomReference;
import java.util.zip.ZipEntry;

public class ClassLoadersTest {

	public static void main(String[] args) {

		System.err.println(String.class.getClassLoader());
		System.err.println(ZipEntry.class.getClassLoader());
		// System.err.println(com.sun.nio.zipfs.ZipCoder.getClassLoader().getParent());

		PhantomReference p = new PhantomReference(null, null);
	}
}
