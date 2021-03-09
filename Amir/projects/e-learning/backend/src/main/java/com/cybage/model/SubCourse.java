package com.cybage.model;

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
public class SubCourse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subCourseId;
	private String subCourseName;
	@Column(length = 500)
	private String subCourseDescription;
	@Column(length = 500)
	private String videoUrl;
	private int videoSequence;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "courseID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Course courseID;

	public SubCourse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SubCourse(int subCourseId, String subCourseName, String subCourseDescription, String videoUrl,
			int videoSequence, Course courseID) {
		super();
		this.subCourseId = subCourseId;
		this.subCourseName = subCourseName;
		this.subCourseDescription = subCourseDescription;
		this.videoUrl = videoUrl;
		this.videoSequence = videoSequence;
		this.courseID = courseID;
	}

	public int getSubCourseId() {
		return subCourseId;
	}

	public void setSubCourseId(int subCourseId) {
		this.subCourseId = subCourseId;
	}

	public String getSubCourseName() {
		return subCourseName;
	}

	public void setSubCourseName(String subCourseName) {
		this.subCourseName = subCourseName;
	}

	public String getSubCourseDescription() {
		return subCourseDescription;
	}

	public void setSubCourseDescription(String subCourseDescription) {
		this.subCourseDescription = subCourseDescription;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public int getVideoSequence() {
		return videoSequence;
	}

	public void setVideoSequence(int videoSequence) {
		this.videoSequence = videoSequence;
	}

	public Course getCourseID() {
		return courseID;
	}

	public void setCourseID(Course courseID) {
		this.courseID = courseID;
	}

	@Override
	public String toString() {
		return "SubCourse [subCourseId=" + subCourseId + ", subCourseName=" + subCourseName + ", subCourseDescription="
				+ subCourseDescription + ", videoUrl=" + videoUrl + ", videoSequence=" + videoSequence + ", courseID="
				+ courseID + "]";
	}

}
