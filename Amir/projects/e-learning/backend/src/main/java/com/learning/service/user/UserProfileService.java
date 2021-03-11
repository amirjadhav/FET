package com.learning.service.user;

import java.util.List;

import com.learning.model.UserProfile;

public interface UserProfileService {

	List<UserProfile> findAll();

	UserProfile findById(int id);

	UserProfile save(UserProfile userProfile);

	UserProfile update(UserProfile userProfile);

	void deleteById(int id);

}
