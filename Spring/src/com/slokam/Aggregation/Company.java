package com.slokam.Aggregation;

public class Company {
	private Unit unit;
	
	// for setter injection for aggregation using this method 
	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	//for construction injection for aggregation
	public Company(Unit unit) {
		this.unit=unit;
	}
	public void doWork() {
		System.out.println("Company work Start");
		unit.doWork();
		System.out.println("Company work Completed");
	}
}
