package com.cybage;

public class EmployeeProfile {
	private String img;
	private String comments;
	public EmployeeProfile() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeProfile(String img, String comments) {
		super();
		this.img = img;
		this.comments = comments;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "EmployeeProfile [img=" + img + ", comments=" + comments + "]";
	}
	
}
