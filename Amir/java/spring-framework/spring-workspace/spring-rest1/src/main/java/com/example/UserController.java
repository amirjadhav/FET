package com.example;

 

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

 

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

 

@RestController
public class UserController {
    List<User> users;
    {
        users = new ArrayList<User>();
        users.add(new User(101, "dm101"));
        users.add(new User(102, "dm102"));
        users.add(new User(103, "dm103"));
        users.add(new User(104, "dm104"));
    }
    
    List<UserV1> usersV1;
    {
        usersV1 = new ArrayList<>();
        usersV1.add(new UserV1(101, "dm101", 123));
        usersV1.add(new UserV1(102, "dm102", 345));
        usersV1.add(new UserV1(103, "dm103", 56756));
        usersV1.add(new UserV1(104, "dm104", 75645));
    }

 

    @RequestMapping(path= "/v1/users",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.status(HttpStatus.FOUND).body(users);
    }

 

    @RequestMapping("/v2/users")
    public ResponseEntity<List<UserV1>> getUsersV2() {
        return ResponseEntity.status(HttpStatus.FOUND).body(usersV1);
    }

 

    
    @RequestMapping("/v1/users/{id}")
    public User getUsers(@PathVariable int id) {
        Optional<User> usr = users.stream().filter(u -> u.getId() == id).findFirst();
        if (!usr.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "given id not found in database");
        }
        return usr.get();
    }

 

    @PostMapping("/v1/users/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String postUser(@RequestBody User user) {
        users.add(user);
        return "successfully added record";
    }

 

    @DeleteMapping("/v1/users/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id)  {
        boolean isDeleted = users.removeIf(u -> u.getId() == id); // java 8
        if (!isDeleted) {
            throw new ResponseStatusException(HttpStatus.OK, "given record could not be deleted as it is not present in db");
        }
        return ResponseEntity.status(HttpStatus.OK).body("deleted record");
    }

 

    @PutMapping("/v1/users/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public String updateUser(@RequestBody User user, @PathVariable int id) {
        users.removeIf(u -> u.getId() == id); // java 8
        users.add(user);
        return "successfully update record...";
    }

 

}