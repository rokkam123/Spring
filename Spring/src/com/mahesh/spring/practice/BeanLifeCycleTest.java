package com.mahesh.spring.practice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"beanLifeCycle-applicationContext.xml");
		Coach coach = context.getBean("myCoach", Coach.class);
		System.out.println(coach.getDailyTask());
		context.close();
	}
}
