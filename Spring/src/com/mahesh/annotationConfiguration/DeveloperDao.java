package com.mahesh.annotationConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class DeveloperDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertDeveloper(DeveloperPojo developerPojo) {
		jdbcTemplate.update("insert into developer values(?,?,?,?)", developerPojo.getId(), developerPojo.getName(),
				developerPojo.getAge(), developerPojo.getCompanyName());
	}

	/*
	 * @queryForObject method 
	 * 1.connection 
	 * 2.prepare statement 
	 * 3.execute 
	 * 4.result 
	 * 5.uses row mapper to convert result set to pojo
	 * 6.return pojo
	 */
	public DeveloperPojo getDeveloperById(int id) {
		/*DeveloperPojo developerPojo = jdbcTemplate.queryForObject("select * from developer where id=?",
				new BeanPropertyRowMapper<DeveloperPojo>(DeveloperPojo.class), id);*/
		DeveloperPojo developerPojo = jdbcTemplate.queryForObject("select * from developer where id=?",
				new OurOwnRowMapper(),id);
		return developerPojo;
	}
	
	/*
	 * @query method
	 * 
	 * 1.connection con
	 * 2.prepare statement
	 * 3.execute query 
	 * 4.result set
	 * 5.repeat calling map row method multiple times
	 * 6.adds all objects into list
	 * 7.return list
	 */
	public List<DeveloperPojo> getAllDevelopers() {
		/*List<DeveloperPojo> listOfDevelopers = (ArrayList<DeveloperPojo>) jdbcTemplate.query("select * from developer",
				new BeanPropertyRowMapper<DeveloperPojo>(DeveloperPojo.class));*/
		List<DeveloperPojo> listOfDevelopers = (ArrayList<DeveloperPojo>) jdbcTemplate.query("select * from developer",
				new OurOwnRowMapper());
		return listOfDevelopers;
	}

	public void deleteDeveloperById(int id) {
		jdbcTemplate.update("delete from developer where id=?",id);
		
	}

	public void updateDeveloperById(int id) {
		
		
	}

	public List<Map<String, Object>> list() {
		List<Map<String, Object>> listOfDeveloper = jdbcTemplate.queryForList("select * from developer");
		return listOfDeveloper;
	}

	public int getCount() {
		Integer count = jdbcTemplate.queryForObject("select count(*) from developer", Integer.class);
		return count;
	}
	public void saveDeveloperList(List<DeveloperPojo> listOfDevelopers) {
		OurBatchPrepareStatementSetter bps=new OurBatchPrepareStatementSetter(listOfDevelopers);
		jdbcTemplate.batchUpdate("insert into developer values(?,?,?,?)",bps);
	}

}
