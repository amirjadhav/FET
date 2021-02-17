package com.cybage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.cybage.repository.UserRepository;


@RestController
public class EmpCrudOperations {
	@Autowired
	UserRepository ur;

}