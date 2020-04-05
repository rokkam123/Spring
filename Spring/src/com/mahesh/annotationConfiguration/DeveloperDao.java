package com.mahesh.annotationConfiguration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.fasterxml.jackson.databind.deser.impl.BeanPropertyMap;

public class DeveloperDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertDeveloper(DeveloperPojo developerPojo) {
		jdbcTemplate.update("insert into developer values(?,?,?,?)", developerPojo.getId(), developerPojo.getName(),
				developerPojo.getAge(), developerPojo.getCompanyName());
	}

	public DeveloperPojo getDeveloperById(int id) {
		DeveloperPojo developerPojo = jdbcTemplate.queryForObject("select * from developer where id=?",
				new BeanPropertyRowMapper<DeveloperPojo>(DeveloperPojo.class), id);
		return developerPojo;
	}

	public List<DeveloperPojo> getAllDevelopers() {
		List<DeveloperPojo> listOfDevelopers = (ArrayList<DeveloperPojo>) jdbcTemplate.query("select * from developer",
				new BeanPropertyRowMapper<DeveloperPojo>(DeveloperPojo.class));
		return listOfDevelopers;
	}

	public void deleteDeveloperById(int id) {
		jdbcTemplate.update("delete from developer where id=?",id);
		
	}

	public void updateDeveloperById(int id) {
		
		
	}

}
