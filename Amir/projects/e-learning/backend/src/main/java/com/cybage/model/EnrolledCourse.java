package com.cybage.model;

import java.io.Serializable;
import java.sql.Date;

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
public class EnrolledCourse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int enrollmentId;
	private Date purchaseDate;
	private int purchasePrice;
	private int currentVideo;
	private boolean isCompleted;
	@Column(length = 1000)
	private String certificateUrl;

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

	public EnrolledCourse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EnrolledCourse(int enrollmentId, Date purchaseDate, int purchasePrice, int currentVideo, boolean isCompleted,
			String certificateUrl, User userID, Course courseId) {
		super();
		this.enrollmentId = enrollmentId;
		this.purchaseDate = purchaseDate;
		this.purchasePrice = purchasePrice;
		this.currentVideo = currentVideo;
		this.isCompleted = isCompleted;
		this.certificateUrl = certificateUrl;
		this.userID = userID;
		this.courseId = courseId;
	}

	public int getEnrollmentId() {
		return enrollmentId;
	}

	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(int purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public int getCurrentVideo() {
		return currentVideo;
	}

	public void setCurrentVideo(int currentVideo) {
		this.currentVideo = currentVideo;
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public String getCertificateUrl() {
		return certificateUrl;
	}

	public void setCertificateUrl(String certificateUrl) {
		this.certificateUrl = certificateUrl;
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
		return "EnrolledCourse [enrollmentId=" + enrollmentId + ", purchaseDate=" + purchaseDate + ", purchasePrice="
				+ purchasePrice + ", currentVideo=" + currentVideo + ", isCompleted=" + isCompleted
				+ ", certificateUrl=" + certificateUrl + ", userID=" + userID + ", courseId=" + courseId + "]";
	}

}
