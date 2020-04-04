package com.mahesh.annotationConfiguration;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserToDatabase {
	public static void main(String[] args) {
		System.out.println("Please Enter Developere ID ");
		Scanner sc = new Scanner(System.in);
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("Please Enter Developere Name ");
		String developerName =sc.nextLine();
		System.out.println("Please Enter Developere Age ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.println("Please Enter Developere CompanyName ");
		String companyName =sc.nextLine();
		DeveloperPojo developerPojo=new DeveloperPojo();
		developerPojo.setId(id);
		developerPojo.setName(developerName);
		developerPojo.setAge(age);
		developerPojo.setCompanyName(companyName);
		ApplicationContext applicationContext=new AnnotationConfigApplicationContext(SpringConfiguration.class);
		DeveloperDao developerDao =(DeveloperDao) applicationContext.getBean("developerDao");
		developerDao.saveDeveloper(developerPojo);
		
	}
}
