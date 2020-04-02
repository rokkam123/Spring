package com.slokam.Aggregation;

public class AggregationConstructionInjection {
	public static void main(String[] args) {
		Employee employee=new Employee();
		Unit unit=new Unit(employee);
		Company company=new Company(unit);
		company.doWork();
	}
}
