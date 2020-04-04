package com.mahesh.annotationConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

//@Component 
/*
* Here we commenting the @component 
* because the this object is created in configuration Class.
*/
public class Developer {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void doWork() {
		jdbcTemplate.update("insert into developer values(1,'mahesh',23,'CGS')");
	}
}
