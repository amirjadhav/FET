package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController // adding @ResponseBody to each method
@RequestMapping("/users")
public class UserController {
	List<User> users;

	{
		users = new ArrayList<User>();
		users.add(new User(101, "Amir"));
		users.add(new User(102, "Amir"));
		users.add(new User(103, "Amir"));
		users.add(new User(104, "Amir"));
		users.add(new User(105, "Amir"));

	} // when UserController is created that time this block is get intialized

	@RequestMapping
//	@ResponseBody   //dont want use html or jsp file this return data used as html format
	public List<User> getUsers() {
		return users;
	}
	@ResponseStatus(code = HttpStatus.FOUND)
	@RequestMapping("/{id}")
	public User getUsers(@PathVariable int id) {

		Optional<User> usr = users.stream().filter(u -> u.getId() == id).findFirst();
		return usr.get();

	}
	@PostMapping()
	public ResponseEntity<String> postUser(@RequestBody User user) {
		users.add(user);
		return ResponseEntity.status(HttpStatus.CREATED).body("User added");
	}
	@DeleteMapping("/{id}")
	public String deleteUsers(@PathVariable int id) {
		users.removeIf(u->u.getId() == id);  //java 8 feature
		return "user deleted";
	}
	@PutMapping("/{id}")
	public String updateUser(@RequestBody User user,@PathVariable int id ) {
		users.removeIf(u->u.getId() == id);
		users.add(user);
		return "User updated";
		
	}
}
