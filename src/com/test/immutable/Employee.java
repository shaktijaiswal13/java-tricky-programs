package com.test.immutable;

import java.util.Date;

/**
 * 
 * @author shaktikumar
 * 
 */

public class Employee extends Person {

			
			
	private Integer experience;

	public Employee(Integer experience) {
		super("", 2, new Date());
		this.experience = experience;
	}

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Integer getExperience() {
		return experience;
	}

}
