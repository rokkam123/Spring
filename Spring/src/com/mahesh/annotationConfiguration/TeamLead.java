package com.mahesh.annotationConfiguration;

import org.springframework.beans.factory.annotation.Autowired;

//@Component 
/*
* Here we commenting the @component 
* because the this object is created in configuration Class.
*/
public class TeamLead {
	private Developer developer;

	@Autowired
	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}

	public void doWork() {
		System.out.println("TeamLead work Start");
		developer.doWork();
		System.out.println("TeamLead work Completed");
	}
}
