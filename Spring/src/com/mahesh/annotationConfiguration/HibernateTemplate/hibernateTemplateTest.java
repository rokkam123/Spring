package com.mahesh.annotationConfiguration.HibernateTemplate;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class hibernateTemplateTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("1.GET USER BY ID");
			System.out.println("2.Exit");
			int option = Integer.parseInt(scanner.nextLine());
			switch (option) {
			case 1:
				System.out.println("Get User by ID logic here");
				getUserByID();
				break;
			case 2:
				System.out.println("Stop the Execution");
				System.exit(0);
				break;
			default:
				break;
			}
		}
	}

	public static void getUserByID() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter User ID");
		int id = Integer.parseInt(scanner.nextLine());
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				SpringConfigurationHibernateTemplate.class);
		UserDao userDao=(UserDao) applicationContext.getBean("userDao");
		User user = userDao.getUserById(id);
		System.out.println(user.toString());

	}
}
