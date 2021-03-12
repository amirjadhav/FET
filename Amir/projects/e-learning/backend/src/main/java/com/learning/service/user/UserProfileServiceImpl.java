package com.learning.service.user;

import java.util.List;

import com.learning.model.UserProfile;
import com.learning.repository.UserProfileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	UserProfileRepository userProfileRepository;

	@Override
	public List<UserProfile> findAll() {

		return userProfileRepository.findAll();
	}

	@Override
	public UserProfile findById(int id) {

		return userProfileRepository.findById(id).get();
	}

	@Override
	public UserProfile save(UserProfile userProfile) {

		return userProfileRepository.save(userProfile);
	}

	@Override
	public UserProfile update(UserProfile userProfile) {

		return userProfileRepository.save(userProfile);
	}

	@Override
	public void deleteById(int id) {
		userProfileRepository.deleteById(id);
	}

}
