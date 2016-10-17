package com.test.classloaders;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ClassLoaderTest {

	public static void main(String args[]) {
		try {
			// printing ClassLoader of this class
			System.err.println("ClassLoaderTest.getClass().getClassLoader() : "
					+ ClassLoaderTest.class.getClassLoader());

			// printing parent ClassLoader of this class's ClassLoader
			System.err
					.println("ClassLoaderTest.class.getClassLoader().getParent() : "
							+ ClassLoaderTest.class.getClassLoader()
									.getParent());

			System.err.println(ClassLoaderTest.class.hashCode());

			// trying to explicitly load this class again using Extension class
			// loader
			Class c1 = Class.forName("com.test.classloaders.ClassLoaderTest",
					true, ClassLoaderTest.class.getClassLoader());

			System.err.println(c1.hashCode());
			
			//====================================================================//
			
			// printing ClassLoader of ClassLoader class
			System.err.println("ClassLoader.getClass().getClassLoader() : "
					+ ClassLoader.class.getClassLoader());
			
			// printing parent ClassLoader of ClassLoader class's ClassLoader
			System.err
			.println("ClassLoader.class.getClassLoader().getParent() : "
					+ ClassLoader.class.getClassLoader()
					.getParent());
			System.err.println(ClassLoader.class.hashCode());

			// trying to explicitly load ClassLoader class again using Extension class
			// loader, will throw exception ClassNotFoundException
			Class c2 = Class.forName("com.test.classloaders.ClassLoader",
					true, ClassLoader.class.getClassLoader().getParent());
			System.err.println(c2.hashCode());
			
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ClassLoaderTest.class.getName()).log(Level.SEVERE,
					null, ex);
		}
	}

}

class ClassLoader {
	static {
		System.err.println("static block");
	}

	{
		System.err.println("non-static block");
	}
}

// Read more:
// http://javarevisited.blogspot.com/2012/12/how-classloader-works-in-java.html#ixzz3EtLvw64L