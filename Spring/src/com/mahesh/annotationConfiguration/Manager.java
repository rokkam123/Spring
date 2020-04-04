package com.mahesh.annotationConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component 
/*
 * Here we commenting the @component 
 * because the this object is created in configuration Class.
 */
public class Manager {
	private TeamLead teamLead;

	@Autowired
	public void setTeamLead(TeamLead teamLead) {
		this.teamLead = teamLead;
	}

	public void doWork() {
		System.out.println("manager work Start");
		teamLead.doWork();
		System.out.println("manager work Completed");
	}
}
