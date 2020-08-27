package com.malatesh.login;

import java.util.List;

import com.malatesh.beans.UserLoginDetails;
import com.malatesh.beans.UserRegistrationInfo;

public interface UserDataAccessLayer {

	List<UserLoginDetails> getUserDetails();

	UserLoginDetails getUserDetailsByUserName(String userName);
	
	void deleteUserDetailsByUserName(String userName);
	
	void updateUserDetailsByUserName(String userName,UserRegistrationInfo regInfo);
	
	UserRegistrationInfo addNewUser(UserRegistrationInfo userDetails);

}
