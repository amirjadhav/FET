package com.cybage.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.User;
import com.cybage.repository.UserRepository;


@RestController
public class UserController {
 
    @Autowired
    private UserRepository ur;
    
    
    @RequestMapping(value = "/find", method = RequestMethod.GET)	//http://localhost:8081/find?searchTerm=swimming&sort=name,desc
    public List<User> findBySearchTerm(@RequestParam("searchTerm") String searchTerm, 
                                          Sort sort) {
        return ur.findByHobby(searchTerm, sort);
    }
 
    
}