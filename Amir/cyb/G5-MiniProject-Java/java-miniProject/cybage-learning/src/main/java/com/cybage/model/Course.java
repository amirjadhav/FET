package com.cybage.model;

public class Course {
	int courseId;
	String courseName;
	int coursePrice;
	int courseDuration;
	String courseAuthor;
	String courseDescription;
	String imageUrl;
	int totalSubCourse;
	
	
	public Course() {
		super();
		this.courseId = -1;
		this.courseName = null;
		this.coursePrice = -1;
		this.courseDuration =-1;
		this.courseAuthor = null;
		this.courseDescription = null;
		this.imageUrl = null;
		this.totalSubCourse = -1;
	}
	
	public Course(int courseId, String courseName, int coursePrice, int courseDuration, String courseAuthor,
			String courseDescription, String imageUrl, int totalSubCourse) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.coursePrice = coursePrice;
		this.courseDuration = courseDuration;
		this.courseAuthor = courseAuthor;
		this.courseDescription = courseDescription;
		this.imageUrl = imageUrl;
		this.totalSubCourse = totalSubCourse;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCoursePrice() {
		return coursePrice;
	}
	public void setCoursePrice(int coursePrice) {
		this.coursePrice = coursePrice;
	}
	public int getCourseDuration() {
		return courseDuration;
	}
	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}
	public String getCourseAuthor() {
		return courseAuthor;
	}
	public void setCourseAuthor(String courseAuthor) {
		this.courseAuthor = courseAuthor;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getTotalSubCourse() {
		return totalSubCourse;
	}
	public void setTotalSubCourse(int totalSubCourse) {
		this.totalSubCourse = totalSubCourse;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ","
				+ " courseName=" + courseName + ","
				+ " coursePrice=" + coursePrice+ ", "
				+ "courseDuration=" + courseDuration + ","
				+ " courseAuthor=" + courseAuthor + ","
				+ " courseDescription="
				+ courseDescription + ","
				+ " imageUrl=" + imageUrl + ","
				+ "totalSubCourse=" + totalSubCourse + "]";
	}

	
}