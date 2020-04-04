package com.mahesh.annotationConfiguration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan("com.mahesh.annotationConfiguration")
public class SpringConfiguration {
	/*
	 * @bean is creating the predefine class objects and injecting the values
	 */
	@Bean
	public Manager manager() {
		return new Manager();
	}

	@Bean
	public TeamLead teamLead() {
		return new TeamLead();
	}

	@Bean
	public Developer developer() {
		return new Developer();
	}

	@Bean
	public BasicDataSource basicDataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setUrl("jdbc:mysql://localhost:3306/SPRING");
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("root");
		basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		return basicDataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(basicDataSource());
		return jdbcTemplate;
	}

}
