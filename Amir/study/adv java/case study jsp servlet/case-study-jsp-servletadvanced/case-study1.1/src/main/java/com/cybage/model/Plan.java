package com.cybage.model;

public class Plan {
	private String planid;
	private String planname;
	private String sportid;
	private double fees;
	private int duration;
	public Plan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Plan(String planid, String planname, String sportid, double fees, int duration) {
		super();
		this.planid = planid;
		this.planname = planname;
		this.sportid = sportid;
		this.fees = fees;
		this.duration = duration;
	}
	public String getPlanid() {
		return planid;
	}
	public void setPlanid(String planid) {
		this.planid = planid;
	}
	public String getPlanname() {
		return planname;
	}
	public void setPlanname(String planname) {
		this.planname = planname;
	}
	public String getSportid() {
		return sportid;
	}
	public void setSportid(String sportid) {
		this.sportid = sportid;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Plan [planid=" + planid + ", planname=" + planname + ", sportid=" + sportid + ", fees=" + fees
				+ ", duration=" + duration + "]";
	}
	
	
}
