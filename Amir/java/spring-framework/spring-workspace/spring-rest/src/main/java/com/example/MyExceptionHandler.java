package com.example;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class MyExceptionHandler {
	@ExceptionHandler(value = Exception.class)
	public String handleException(Exception e) {
		return "Something going wrong..." + e.getLocalizedMessage();
	}
}
