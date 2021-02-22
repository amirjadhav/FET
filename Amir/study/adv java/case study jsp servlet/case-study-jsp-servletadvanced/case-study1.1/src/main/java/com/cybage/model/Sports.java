package com.cybage.model;

public class Sports {
	private String sportsId;
	private String sportsName;
	
	
	public Sports() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Sports(String sportsId, String sportsName) {
		super();
		this.sportsId = sportsId;
		this.sportsName = sportsName;
	}


	public String getSportsId() {
		return sportsId;
	}


	public void setSportsId(String sportsId) {
		this.sportsId = sportsId;
	}


	public String getSportsName() {
		return sportsName;
	}


	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}


	@Override
	public String toString() {
		return "Sports [sportsId=" + sportsId + ", sportsName=" + sportsName + "]";
	}
	
	
}
