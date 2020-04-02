package com.slokam.CompositionRelationInjection;

public class TeamLead {
	private Developer developer=new Developer();
	public void doWork() {
		System.out.println("TeamLead work Start");
		developer.doWork();
		System.out.println("TeamLead work Completed");
	}
}
