package com.slokam.Aggregation;

public class AggregationSetterInjection {
	public static void main(String[] args) {
		Company company=new Company();
		Unit unit=new Unit();
		Employee employee=new Employee();
		company.setUnit(unit);
		unit.setEmployee(employee);
		company.doWork();
	}
}
