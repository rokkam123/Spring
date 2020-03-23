package com.mahesh.spring.practice;

public class MyApplication {
	public static void main(String[] args) {
		Coach coach=new HockeyCoach();
		
		System.out.println(coach.getDailyTask());
	}
}
