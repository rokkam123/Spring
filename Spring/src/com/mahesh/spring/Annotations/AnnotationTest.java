package com.mahesh.spring.Annotations;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		Company companyBean = context.getBean("thisProject",Company.class);
		System.out.println(companyBean.getProjectNames());
		context.close();
	}
}
