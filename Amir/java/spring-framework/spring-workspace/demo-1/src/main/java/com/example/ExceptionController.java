package com.example;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice			//applicable for exception handling at application level
public class ExceptionController {

	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(Exception ex) {
		ModelAndView mv = new ModelAndView("myerror");
		mv.addObject("msg", "not able to process due exception");
		return mv;
	}
}
