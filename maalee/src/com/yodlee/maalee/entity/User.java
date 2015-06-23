package com.yodlee.maalee.entity;

import java.util.Date;

public class User {
	private String emailId;
	private String phoneNumber;
	private String password;
	private Date dateRegistered;
	private String name;
	
	public User() {
		super();
	}
	
	public User(String emailId, String phoneNumber, String password,
			Date dateRegistered, String name) {
		super();
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.dateRegistered = dateRegistered;
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDateRegistered() {
		return dateRegistered;
	}

	public void setDateRegistered(Date dateRegistered) {
		this.dateRegistered = dateRegistered;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [emailId=" + emailId + ", phoneNumber=" + phoneNumber
				+ ", dateRegistered=" + dateRegistered + ", name=" + name + "]";
	}
	
}
