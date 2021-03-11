package com.learning.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commentID;
	@Column(length = 1000)
	private String commentDescription;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "userID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User userID;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "courseId", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Course courseId;

	@OneToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "subCourseID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private SubCourse subCourseID;

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(int commentID, String commentDescription, User userID, Course courseId, SubCourse subCourseID) {
		super();
		this.commentID = commentID;
		this.commentDescription = commentDescription;
		this.userID = userID;
		this.courseId = courseId;
		this.subCourseID = subCourseID;
	}

	public int getCommentID() {
		return commentID;
	}

	public void setCommentID(int commentID) {
		this.commentID = commentID;
	}

	public String getCommentDescription() {
		return commentDescription;
	}

	public void setCommentDescription(String commentDescription) {
		this.commentDescription = commentDescription;
	}

	public User getUserID() {
		return userID;
	}

	public void setUserID(User userID) {
		this.userID = userID;
	}

	public Course getCourseId() {
		return courseId;
	}

	public void setCourseId(Course courseId) {
		this.courseId = courseId;
	}

	public SubCourse getSubCourseID() {
		return subCourseID;
	}

	public void setSubCourseID(SubCourse subCourseID) {
		this.subCourseID = subCourseID;
	}

	@Override
	public String toString() {
		return "Comment [commentID=" + commentID + ", commentDescription=" + commentDescription + ", userID=" + userID
				+ ", courseId=" + courseId + ", subCourseID=" + subCourseID + "]";
	}

}
