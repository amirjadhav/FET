package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.User;
import com.cybage.model.UserProfile;
import com.cybage.service.user.UserProfileService;
import com.cybage.service.user.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	UserProfileService userProfileService;

	/************************ USER ************************/

	@GetMapping
	public List<User> getAllUsers() {
		return userService.findAll();
	}

	@GetMapping("/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.findById(id);
	}

	@PostMapping
	public User addUser(@RequestBody User user) {
		return userService.save(user);
	}

	@PutMapping
	public User updateUser(@RequestBody User user) {
		return userService.update(user);
	}

	@DeleteMapping("/{id}")
	public String deleteUserById(@PathVariable int id) {
		userService.deleteById(id);
		return "user deleted";
	}

	/************************ USER PROFILE ************************/

	@GetMapping("/profile")
	public List<UserProfile> getAllUsersProfile() {
		return userProfileService.findAll();
	}

	@GetMapping("/profile/{id}")
	public UserProfile getUserProfileById(@PathVariable int id) {
		return userProfileService.findById(id);
	}

	@PostMapping("/profile")
	public UserProfile addUserProfile(@RequestBody UserProfile userProfile) {
		return userProfileService.save(userProfile);
	}

	@PutMapping("/profile")
	public UserProfile updateUserProfile(@RequestBody UserProfile userProfile) {
		return userProfileService.update(userProfile);
	}

	@DeleteMapping("/profile/{id}")
	public String deleteUserProfileById(@PathVariable int id) {
		userProfileService.deleteById(id);
		return "user deleted";
	}

}
