package com.cybage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.Controller;

public class WelcomeController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        System.out.println("Inside WelcomeController");

        ModelAndView model = new ModelAndView("welcome");
        model.addObject("msg", "cybage, pune");
        
        return model;
    }
}