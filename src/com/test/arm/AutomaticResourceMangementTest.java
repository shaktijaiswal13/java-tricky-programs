package com.test.arm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AutomaticResourceMangementTest {

	// New way with JDK 7
	public static void main(String[] args) throws IOException {
		try (FileInputStream is = new MyInputStream(
				"/Users/shaktikumar/Downloads/Neha Data/Notes/aarondev.txt");
				FileOutputStream os = new MyOutputStream(
						"/Users/shaktikumar/Downloads/Neha Data/Notes/aarondev_New.txt")) {
			int data;
			while ((data = is.read()) != -1) {
				os.write(data);
			}
		}
	}
}

class MyInputStream extends FileInputStream {

	public MyInputStream(String file) throws FileNotFoundException {
		super(file);
	}

	@Override
	public void close() throws IOException {
		System.err.println("in close method of MyInputStream......");
		super.close();
	}
}

class MyOutputStream extends FileOutputStream {

	public MyOutputStream(String file) throws FileNotFoundException {
		super(file);
	}

	@Override
	public void close() throws IOException {
		System.err.println("in close method of MyOutputStream......");
		super.close();
	}
}
