package com.test.trickyquestions;

public class TrickyQuestion1 {

	public static void main(String[] args) {
		try {
			String str =null;
			System.err.println("in try block.......");
			System.err.println(str.length());
			//return;
			System.exit(0);
		} catch (NullPointerException npe) {
			npe.printStackTrace();
			System.err.println("in catch block.... catched NPE....");
			System.exit(0);
			return;
		} finally {
			System.err.println("in finally block.. now returning.....");
		}
	}
}
