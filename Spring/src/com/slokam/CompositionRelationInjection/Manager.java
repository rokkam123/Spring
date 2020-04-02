package com.slokam.CompositionRelationInjection;

public class Manager {
	private TeamLead teamLead=new TeamLead();
	public void doWork() {
		System.out.println("manager work Start");
		teamLead.doWork();
		System.out.println("manager work Completed");
	}
}
