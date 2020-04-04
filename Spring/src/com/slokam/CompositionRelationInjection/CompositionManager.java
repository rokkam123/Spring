package com.slokam.CompositionRelationInjection;

public class CompositionManager {
	private CompositionTeamLead teamLead=new CompositionTeamLead();
	public void doWork() {
		System.out.println("manager work Start");
		teamLead.doWork();
		System.out.println("manager work Completed");
	}
}
