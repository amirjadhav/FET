package com.learning.model;

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
public class UserProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userProfileId;
	private String fullName;
	private Date dob;
	private String education;
	@Column(length = 500)
	private String address;
	@Column(length = 500)
	private String imageUrl;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "userID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User userID;

	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserProfile(int userProfileId, String fullName, Date dob, String education, String address, String imageUrl,
			User userID) {
		super();
		this.userProfileId = userProfileId;
		this.fullName = fullName;
		this.dob = dob;
		this.education = education;
		this.address = address;
		this.imageUrl = imageUrl;
		this.userID = userID;
	}

	public int getUserProfileId() {
		return userProfileId;
	}

	public void setUserProfileId(int userProfileId) {
		this.userProfileId = userProfileId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public User getUserID() {
		return userID;
	}

	public void setUserID(User userID) {
		this.userID = userID;
	}

	@Override
	public String toString() {
		return "UserProfile [userProfileId=" + userProfileId + ", fullName=" + fullName + ", dob=" + dob
				+ ", education=" + education + ", address=" + address + ", imageUrl=" + imageUrl + ", userID=" + userID
				+ "]";
	}

}
