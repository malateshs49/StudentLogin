package com.malatesh.beans;

public class UserRegistrationInfo extends UserLoginDetails {

	private String emailId;

	private String mobileNumber;

	private UserLoginDetails userLoginDetails;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public UserLoginDetails getUserLoginDetails() {
		return userLoginDetails;
	}

	public void update() {
		userLoginDetails.setUserName(this.getUserName());
		userLoginDetails.setPassword(this.getPassword());
	}

	public UserRegistrationInfo() {
		userLoginDetails = new UserLoginDetails();
	}

	@Override
	public String toString() {
		return "Stroing details of " + this.getUserName();
	}

}
