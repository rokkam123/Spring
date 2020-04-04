package com.mahesh.annotationConfiguration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestMethod {
	public static void main(String[] args) {
	ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfiguration.class);
	Manager manager=(Manager) context.getBean("manager");
	manager.doWork();
	}
}
