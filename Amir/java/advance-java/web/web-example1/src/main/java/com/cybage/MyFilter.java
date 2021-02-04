package com.cybage;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

public class MyFilter implements Filter {

	public MyFilter() {
		// constructor
	}

	public void destroy() {
		// destructor
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// we can modify request and responce object
		// date coming from user in format --> convert into required format
		// System.out.println(request.getServletContext());
		System.out.println("i am passing through filter" + new Date() + request.getServerPort());
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}
}