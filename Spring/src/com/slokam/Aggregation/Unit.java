package com.slokam.Aggregation;

public class Unit {
	private Employee employee;
	public Unit(Employee employee) {
		this.employee = employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public void doWork() {
		System.out.println("Unit work Start");
		employee.doWork();
		System.out.println("Unit work Completed");
	}
}
