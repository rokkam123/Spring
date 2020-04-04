package com.mahesh.annotationConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class DeveloperDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void saveDeveloper(DeveloperPojo developerPojo) {
		jdbcTemplate.update("insert into developer values(?,?,?,?)",developerPojo.getId(),developerPojo.getName(),developerPojo.getAge(),developerPojo.getCompanyName());
	}
	
}
