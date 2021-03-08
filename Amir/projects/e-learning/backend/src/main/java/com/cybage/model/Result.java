package com.cybage.model;

import java.io.Serializable;

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
public class Result implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "userID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User userID;

	@Id
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "courseId", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Course courseId;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int resultId;

	private int marks;

	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Result(User userID, Course courseId, int resultId, int marks) {
		super();
		this.userID = userID;
		this.courseId = courseId;
		this.resultId = resultId;
		this.marks = marks;
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

	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Result [userID=" + userID + ", courseId=" + courseId + ", resultId=" + resultId + ", marks=" + marks +"]";
	}

}
