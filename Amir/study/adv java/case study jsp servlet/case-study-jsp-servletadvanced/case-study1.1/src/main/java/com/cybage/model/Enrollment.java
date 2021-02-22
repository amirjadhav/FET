package com.cybage.model;

import java.time.LocalDate;

public class Enrollment {
	private String enrollid;
	private String username;
	private String planid;
	private String batchid;
	private LocalDate startdate;
	private String status;
	public Enrollment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Enrollment(String enrollid, String username, String planid, String batchid, LocalDate startdate,
			String status) {
		super();
		this.enrollid = enrollid;
		this.username = username;
		this.planid = planid;
		this.batchid = batchid;
		this.startdate = startdate;
		this.status = status;
	}
	public String getEnrollid() {
		return enrollid;
	}
	public void setEnrollid(String enrollid) {
		this.enrollid = enrollid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPlanid() {
		return planid;
	}
	public void setPlanid(String planid) {
		this.planid = planid;
	}
	public String getBatchid() {
		return batchid;
	}
	public void setBatchid(String batchid) {
		this.batchid = batchid;
	}
	public LocalDate getStartdate() {
		return startdate;
	}
	public void setStartdate(LocalDate startdate) {
		this.startdate = startdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Enrollment [enrollid=" + enrollid + ", username=" + username + ", planid=" + planid + ", batchid="
				+ batchid + ", startdate=" + startdate + ", status=" + status + "]";
	}		
}
