package com.mahesh.spring.practice;

import org.springframework.context.support.ClassPathXmlApplicationContext;
 
public class HelloSpring { 
	public static void main(String[] args) {
		// load the spring container
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// creating the container object
		Coach theCoach=context.getBean("myCoach", Coach.class);
		// call the methods
		System.out.println(theCoach.getDailyTask());
		// close the context.
		context.close();
	}
}
