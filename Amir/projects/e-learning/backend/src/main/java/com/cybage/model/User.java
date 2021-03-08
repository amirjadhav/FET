package com.cybage.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String userName;
	private String userEmail;
	
	@Column(nullable = false)
	private String userPassword;
	private String userRole;
	private boolean isPrime;
	private int loginAttempt;
	private boolean isLocked;
	private boolean isReqUnlock;
	
	@Column(nullable = true)
	private int opt;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String userName, String userEmail, String userPassword, String userRole, boolean isPrime,
			int loginAttempt, boolean isLocked, boolean isReqUnlock, int opt) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userRole = userRole;
		this.isPrime = isPrime;
		this.loginAttempt = loginAttempt;
		this.isLocked = isLocked;
		this.isReqUnlock = isReqUnlock;
		this.opt = opt;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public boolean isPrime() {
		return isPrime;
	}

	public void setPrime(boolean isPrime) {
		this.isPrime = isPrime;
	}

	public int getLoginAttempt() {
		return loginAttempt;
	}

	public void setLoginAttempt(int loginAttempt) {
		this.loginAttempt = loginAttempt;
	}

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public boolean isReqUnlock() {
		return isReqUnlock;
	}

	public void setReqUnlock(boolean isReqUnlock) {
		this.isReqUnlock = isReqUnlock;
	}

	public int getOpt() {
		return opt;
	}

	public void setOpt(int opt) {
		this.opt = opt;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", userRole=" + userRole + ", isPrime=" + isPrime + ", loginAttempt=" + loginAttempt
				+ ", isLocked=" + isLocked + ", isReqUnlock=" + isReqUnlock + ", opt=" + opt + "]";
	}

}
