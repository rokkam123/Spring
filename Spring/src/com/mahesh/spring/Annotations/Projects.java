package com.mahesh.spring.Annotations;

import org.springframework.stereotype.Component;

@Component("thisProject")
public class Projects implements Company {
	@Override
	public String getProjectNames() {
		return "Project Name is : ZOMATO ";
	}
}
