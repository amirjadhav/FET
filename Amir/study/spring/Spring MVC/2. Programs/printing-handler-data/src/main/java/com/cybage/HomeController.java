package com.cybage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Controller
public class HomeController {
	@Autowired
	ApplicationContext context;
	
	@RequestMapping("/home")
	public String home(Model model, HttpServletRequest request) {
		Map<String, HandlerMapping> matchingBeans = BeanFactoryUtils.beansOfTypeIncludingAncestors(
				context, HandlerMapping.class, true, false);

		matchingBeans.forEach((k, v) -> System.out.printf("order:%s %s=%s%n",
				((Ordered) v).getOrder(),
				k, v.getClass().getSimpleName()));
		
		
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(101, "dm101", "email"));
		list.add(new Employee(102, "dm102", "email"));
		model.addAttribute("employees", list);
		
		return "home";
	}
	
}
