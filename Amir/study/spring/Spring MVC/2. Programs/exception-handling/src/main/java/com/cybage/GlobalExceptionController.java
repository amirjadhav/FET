package com.cybage;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionController {

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex) {

		ModelAndView model = new ModelAndView("ExceptionPage");
		model.addObject("message", ex.getMessage());
		System.out.println("using global exception handling");
		return model;
	}
}

