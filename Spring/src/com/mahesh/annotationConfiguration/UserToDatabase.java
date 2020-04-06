package com.mahesh.annotationConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
			System.out.println("6.COUNT");
			System.out.println("7.LIST");
			System.out.println("8.BatchUpdate");
			System.out.println("9.EXIT");
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
				System.out.println("getCount logic Goes Here");
				getCount();
				break;
			case 7:
				System.out.println("GetAll logic Goes Here");
				list();
				break;
			case 8:
				System.out.println("Batch update  logic Goes Here");
				OurBatchUpdate();
				break;
			case 9:
				System.out.println("Exit logic Goes Here");
				System.exit(0);
				break;

			}

		}
	}

	public static void OurBatchUpdate() {
		DeveloperPojo developerPojo1=new DeveloperPojo();
		developerPojo1.setId(3);
		developerPojo1.setName("B");
		developerPojo1.setAge(21);
		developerPojo1.setCompanyName("B-Company");
		DeveloperPojo developerPojo2=new DeveloperPojo();
		developerPojo2.setId(4);
		developerPojo2.setName("c");
		developerPojo2.setAge(22);
		developerPojo2.setCompanyName("C-Company"); 
		DeveloperPojo developerPojo3=new DeveloperPojo();
		developerPojo3.setId(5);
		developerPojo3.setName("D");
		developerPojo3.setAge(22);
		developerPojo3.setCompanyName("D-Company"); 
		List<DeveloperPojo> developerList=new ArrayList<>();
		developerList.add(developerPojo1);
		developerList.add(developerPojo2);
		developerList.add(developerPojo3);
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		DeveloperDao developerDao = (DeveloperDao) applicationContext.getBean("developerDao");
		developerDao.saveDeveloperList(developerList);
	}

	public static void list() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		DeveloperDao developerDao = (DeveloperDao) applicationContext.getBean("developerDao");
		List<Map<String, Object>> list = developerDao.list();
		for (Map<String, Object> map : list) {
			System.out.println("========================");
			System.out.println(map.get("id"));
			System.out.println(map.get("name"));
			System.out.println(map.get("age"));
			System.out.println(map.get("companyName"));
			System.out.println("========================");
		}
	}

	public static void getCount() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		DeveloperDao developerDao = (DeveloperDao) applicationContext.getBean("developerDao");
		int count = developerDao.getCount();
		System.out.println(count);
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
