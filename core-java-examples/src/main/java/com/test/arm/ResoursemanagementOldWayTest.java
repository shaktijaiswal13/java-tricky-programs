package com.test.arm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ResoursemanagementOldWayTest {
	//old way before JDK 7
	public static void main(String[] args) throws IOException {
		MyInputStream is = null;
		MyOutputStream os = null;
		try {
			is = new MyInputStream("/Users/shaktikumar/Downloads/Neha Data/Notes/issues.txt");
			os = new MyOutputStream("/Users/shaktikumar/Downloads/Neha Data/Notes/issues_New.txt");
			int data;
			while ((data = is.read()) != -1) {
				os.write(data);
			}
		} finally {
			if (is != null) {
				is.close();
			}
			if (os != null) {
				os.close();
			}
		}

	}
}
