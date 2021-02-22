package com.cybage.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Batch {
	private String batchid;
	private String batchname;
	private String sportsid;
	private LocalDate batchStartDate;
	private LocalTime batchTime;
	private double batchDuration;
	private int batchSize;
	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Batch(String batchid, String batchname, String sportsid, LocalDate batchStartDate, LocalTime batchTime,
			double batchDuration, int batchSize) {
		super();
		this.batchid = batchid;
		this.batchname = batchname;
		this.sportsid = sportsid;
		this.batchStartDate = batchStartDate;
		this.batchTime = batchTime;
		this.batchDuration = batchDuration;
		this.batchSize = batchSize;
	}
	public String getBatchid() {
		return batchid;
	}
	public void setBatchid(String batchid) {
		this.batchid = batchid;
	}
	public String getBatchname() {
		return batchname;
	}
	public void setBatchname(String batchname) {
		this.batchname = batchname;
	}
	public String getSportsid() {
		return sportsid;
	}
	public void setSportsid(String sportsid) {
		this.sportsid = sportsid;
	}
	public LocalDate getBatchStartDate() {
		return batchStartDate;
	}
	public void setBatchStartDate(LocalDate batchStartDate) {
		this.batchStartDate = batchStartDate;
	}
	public LocalTime getBatchTime() {
		return batchTime;
	}
	public void setBatchTime(LocalTime batchTime) {
		this.batchTime = batchTime;
	}
	public double getBatchDuration() {
		return batchDuration;
	}
	public void setBatchDuration(double batchDuration) {
		this.batchDuration = batchDuration;
	}
	public int getBatchSize() {
		return batchSize;
	}
	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}
	@Override
	public String toString() {
		return "Batch [batchid=" + batchid + ", batchname=" + batchname + ", sportsid=" + sportsid + ", batchStartDate="
				+ batchStartDate + ", batchTime=" + batchTime + ", batchDuration=" + batchDuration + ", batchSize="
				+ batchSize + "]";
	}	
}
