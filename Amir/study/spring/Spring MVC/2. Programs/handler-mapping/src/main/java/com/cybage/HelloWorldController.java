package com.cybage;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class HelloWorldController extends AbstractController
{
	
	@Autowired
	ApplicationContext context;
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("Inside HelloWorldController");
		Map<String, HandlerMapping> matchingBeans = BeanFactoryUtils.beansOfTypeIncludingAncestors(
				context, HandlerMapping.class, true, false);

		matchingBeans.forEach((k, v) -> System.out.printf("order:%s %s=%s%n",
				((Ordered) v).getOrder(),
				k, v.getClass().getSimpleName()));
		ModelAndView model = new ModelAndView("hello");
		model.addObject("msg", "cybage, pune");

		return model;
	}
}