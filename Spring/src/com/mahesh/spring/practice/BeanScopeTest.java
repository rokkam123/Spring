package com.mahesh.spring.practice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanscope-applicationContext.xml");
		Coach coach1 = context.getBean("myCoach", Coach.class);
		Coach coach2 = context.getBean("myCoach", Coach.class);
		boolean result = coach1 == coach2;//for creating single object only .this singleton class..
		
		System.out.println(result);//here true is singleton scope
		System.out.println(result);//here false is prototype scope
		
		System.out.println(coach1);
		System.out.println(coach2);

	}
}
