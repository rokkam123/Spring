package com.mahesh.annotationConfiguration;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class OurOwnRowMapper implements RowMapper<DeveloperPojo> {

	@Override
	public DeveloperPojo mapRow(ResultSet rs, int rowNum) throws SQLException {
		DeveloperPojo developerPojo=new DeveloperPojo();
		developerPojo.setId(rs.getInt("id"));
		developerPojo.setName(rs.getString("name"));
		developerPojo.setAge(rs.getInt("age"));
		developerPojo.setCompanyName(rs.getString("companyName"));
		return developerPojo;
	}

}
