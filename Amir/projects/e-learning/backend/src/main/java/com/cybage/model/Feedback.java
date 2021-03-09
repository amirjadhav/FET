package com.cybage.model;

import java.io.Serializable;

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
public class Feedback implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feedbackID;

	@Column(length = 1000)
	private String feedbackDescription;

	@Column(nullable = true)
	private int rating;

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

	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Feedback(int feedbackID, String feedbackDescription, int rating, User userID, Course courseId) {
		super();
		this.feedbackID = feedbackID;
		this.feedbackDescription = feedbackDescription;
		this.rating = rating;
		this.userID = userID;
		this.courseId = courseId;
	}

	public int getFeedbackID() {
		return feedbackID;
	}

	public void setFeedbackID(int feedbackID) {
		this.feedbackID = feedbackID;
	}

	public String getFeedbackDescription() {
		return feedbackDescription;
	}

	public void setFeedbackDescription(String feedbackDescription) {
		this.feedbackDescription = feedbackDescription;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
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

	@Override
	public String toString() {
		return "Feedback [feedbackID=" + feedbackID + ", feedbackDescription=" + feedbackDescription + ", rating="
				+ rating + ", userID=" + userID + ", courseId=" + courseId + "]";
	}

}
