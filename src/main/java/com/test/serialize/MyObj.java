package com.test.serialize;

import java.io.Serializable;

public class MyObj implements Serializable{
	private final String a;
	
	public MyObj(String a) {
		this.a = a;
	}
	
	public String getA() {
		return this.a;
	}

}
