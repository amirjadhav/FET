package com.cybage;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping("/home")
	public String home(Model model) {
		Map<String, String> map = new HashMap<>();
	    map.put("spring", "mvc");
	    map.put("java", "programming");
	    map.put("angular", "front end");
	    model.addAttribute("message", "cybage");
	    model.mergeAttributes(map);
	    return "home";	
	}
	@RequestMapping("/admin")
	public String admin(ModelMap map) {
		map.addAttribute("welcomeMessage", "welcome");
	    map.addAttribute("message", "cybage");
	    return "admin";
	}
	@GetMapping("/index")
	public ModelAndView index() {
	    ModelAndView modelAndView = new ModelAndView("index");
	    modelAndView.addObject("message", "cybage, pune");
	    return modelAndView;
	}


	@GetMapping("/goToViewPage")
	public ModelAndView passParametersWithModelAndView() {
	    ModelAndView modelAndView = new ModelAndView("viewPage");
	    modelAndView.addObject("message", "cybage");
	    return modelAndView;
	}
	
	
	
	
	
}
