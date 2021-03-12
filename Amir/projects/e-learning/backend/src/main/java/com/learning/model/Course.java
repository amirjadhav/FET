package com.learning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	private String courseName;
	private double coursePrice;
	private int courseDuration;
	private String courseAuthor;
	@Column(length = 500)
	private String courseDescription;
	@Column(length = 500)
	private String image_url;
	private int totalSubCourse;
	private int likes;
	private int totalMarks;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "categoryId", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Category categoryID;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(int courseId, String courseName, double coursePrice, int courseDuration, String courseAuthor,
			String courseDescription, String image_url, int totalSubCourse, int likes, int totalMarks,
			Category categoryID) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.coursePrice = coursePrice;
		this.courseDuration = courseDuration;
		this.courseAuthor = courseAuthor;
		this.courseDescription = courseDescription;
		this.image_url = image_url;
		this.totalSubCourse = totalSubCourse;
		this.likes = likes;
		this.totalMarks = totalMarks;
		this.categoryID = categoryID;
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

	public double getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(double coursePrice) {
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

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public int getTotalSubCourse() {
		return totalSubCourse;
	}

	public void setTotalSubCourse(int totalSubCourse) {
		this.totalSubCourse = totalSubCourse;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}

	public Category getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(Category categoryID) {
		this.categoryID = categoryID;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", coursePrice=" + coursePrice
				+ ", courseDuration=" + courseDuration + ", courseAuthor=" + courseAuthor + ", courseDescription="
				+ courseDescription + ", image_url=" + image_url + ", totalSubCourse=" + totalSubCourse + ", likes="
				+ likes + ", totalMarks=" + totalMarks + ", categoryID=" + categoryID + "]";
	}

}
