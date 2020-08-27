package com.malatesh.login;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.stereotype.Repository;

import com.malatesh.beans.UserLoginDetails;
import com.malatesh.beans.UserRegistrationInfo;

@Repository
public class UserDataAccessLayerImpl implements UserDataAccessLayer {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public List<UserLoginDetails> getUserDetails() {
		List<UserRegistrationInfo> userInfo = mongoTemplate.findAll(UserRegistrationInfo.class);
		return userInfo.stream().map(p -> p.getUserLoginDetails()).collect(Collectors.toList());
	}

	@Override
	public UserLoginDetails getUserDetailsByUserName(String userName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userName").is(userName));
		UserRegistrationInfo registrationinfo = mongoTemplate.findOne(query, UserRegistrationInfo.class);
		return registrationinfo.getUserLoginDetails();
	}

	@Override
	public void deleteUserDetailsByUserName(String userName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userName").is(userName));
		mongoTemplate.remove(query, UserRegistrationInfo.class);

	}

	@Override
	public void updateUserDetailsByUserName(String userName,UserRegistrationInfo regInfo) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userName").is(userName));
		Update update = new Update();
		update.set("mobileNumber", regInfo.getMobileNumber());
		mongoTemplate.updateFirst(query, update, UserRegistrationInfo.class);

	}

	@Override
	public UserRegistrationInfo addNewUser(UserRegistrationInfo userDetails) {
		mongoTemplate.save(userDetails);
		return userDetails;
	}

}
