package com.mahesh.annotationConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserToDatabase {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Enter Your Option");
			System.out.println("1.INSERT");
			System.out.println("2.UPDATE");
			System.out.println("3.DELETE");
			System.out.println("4.GETBYID");
			System.out.println("5.GETALL");
			System.out.println("6.EXIT");
			int option = Integer.parseInt(sc.nextLine());
			switch (option) {
			case 1:
				System.out.println("Insert logic Goes Here");
				insert();
				break;
			case 2:
				System.out.println("Update logic Goes Here");
				updateDeveloperById();
				break;
			case 3:
				System.out.println("Delete logic Goes Here");
				deleteDeveloperById();
				break;
			case 4:
				System.out.println("GetByID logic Goes Here");
				getDeveloperById();
				break;
			case 5:
				System.out.println("GetAll logic Goes Here");
				getAllDevelopers();
				break;
			case 6:
				System.out.println("Exit logic Goes Here");
				System.exit(0);
				break;

			}

		}
	}

	public static void insert() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter Developere ID ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.println("Please Enter Developere Name ");
		String developerName = sc.nextLine();
		System.out.println("Please Enter Developere Age ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.println("Please Enter Developere CompanyName ");
		String companyName = sc.nextLine();
		DeveloperPojo developerPojo = new DeveloperPojo();
		developerPojo.setId(id);
		developerPojo.setName(developerName);
		developerPojo.setAge(age);
		developerPojo.setCompanyName(companyName);
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		DeveloperDao developerDao = (DeveloperDao) applicationContext.getBean("developerDao");
		developerDao.insertDeveloper(developerPojo);
	}

	public static void updateDeveloperById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter Developere ID ");
		int id = Integer.parseInt(sc.nextLine());
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		DeveloperDao developerDao = (DeveloperDao) applicationContext.getBean("developerDao");
		developerDao.updateDeveloperById(id);
	}

	public static void getDeveloperById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter Developere ID ");
		int id = Integer.parseInt(sc.nextLine());
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		DeveloperDao developerDao = (DeveloperDao) applicationContext.getBean("developerDao");
		DeveloperPojo developerPojo = developerDao.getDeveloperById(id);
		System.out.println("==========================");
		System.out.println(developerPojo.getId());
		System.out.println(developerPojo.getName());
		System.out.println(developerPojo.getAge());
		System.out.println(developerPojo.getCompanyName());
		System.out.println("==========================");
	}

	public static void deleteDeveloperById() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter Developere ID ");
		int id = Integer.parseInt(sc.nextLine());
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		DeveloperDao developerDao = (DeveloperDao) applicationContext.getBean("developerDao");
		developerDao.deleteDeveloperById(id);
	}

	public static void getAllDevelopers() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		DeveloperDao developerDao = (DeveloperDao) applicationContext.getBean("developerDao");
		List<DeveloperPojo> listOfDevelopers = developerDao.getAllDevelopers();
		for (DeveloperPojo developerPojo : listOfDevelopers) {
			System.out.println("==========================");
			System.out.println(developerPojo.getId());
			System.out.println(developerPojo.getName());
			System.out.println(developerPojo.getAge());
			System.out.println(developerPojo.getCompanyName());
			System.out.println("==========================");
		}
	}
}
