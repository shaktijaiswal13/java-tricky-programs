package com.test.classloaders;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ClassLoaderTest {

	static {
		System.out.println("static block");
	}

	{
		System.out.println("non-static block");
	}

	public static void main(String args[]) {
		try {
			// printing ClassLoader of this class
			System.out.println("ClassLoaderTest.getClass().getClassLoader() : "
					+ ClassLoaderTest.class.getClassLoader());

			// printing parent ClassLoader of this class's ClassLoader
			System.out
					.println("ClassLoaderTest.class.getClassLoader().getParent() : "
							+ ClassLoaderTest.class.getClassLoader()
									.getParent());

			System.out.println(ClassLoaderTest.class.hashCode());

			// trying to explicitly load this class again using Extension class
			// loader
			Class c1 = Class.forName("com.test.classloaders.ClassLoaderTest",
					true, ClassLoaderTest.class.getClassLoader());

			System.out.println(c1.hashCode());
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ClassLoaderTest.class.getName()).log(Level.SEVERE,
					null, ex);
		}
	}

}

// Read more:
// http://javarevisited.blogspot.com/2012/12/how-classloader-works-in-java.html#ixzz3EtLvw64L