package com.mahesh.spring.practice;

public class HockeyCoach implements Coach {

	@Override
	public String getDailyTask() {
		return "Hockey Practice 30 Minutes";
	}
	public void springIntiMethod() {
		System.out.println("springIntiMethod is called before container is started.");
	}
	public void springDistroyMethod() {
		System.out.println("springDistroyMethod is called after container is shutdown.");
	}

}
