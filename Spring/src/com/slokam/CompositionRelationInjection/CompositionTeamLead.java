package com.slokam.CompositionRelationInjection;

public class CompositionTeamLead {
	private CompositionDeveloper developer=new CompositionDeveloper();
	public void doWork() {
		System.out.println("TeamLead work Start");
		developer.doWork();
		System.out.println("TeamLead work Completed");
	}
}
