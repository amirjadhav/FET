package com.cybage.controller;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.dao.UserDao;
import com.cybage.dao.UserDaoImpl;
import com.cybage.service.UserService;
import com.cybage.model.Category;
import com.cybage.model.Course;
import com.cybage.service.UserServiceImpl;

@ServletSecurity(value = @HttpConstraint(rolesAllowed = {"user"}))
public class UserController extends HttpServlet {
	
	private UserDao userDao = new UserDaoImpl();

	private UserService userService = new UserServiceImpl(userDao);

	private static final long serialVersionUID = 1L;

	public UserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter pw = response.getWriter();

		String path = request.getPathInfo();

		if (path.equals("/list")) {
			try {
				List<Category> categories = userService.findCategory();
				request.setAttribute("categories", categories);

				request.getRequestDispatcher("/index.jsp").forward(request, response);

			} catch (Exception e) {
				System.out.println("error occurred: " + e.getMessage());
			}
		}
		
		if(path.equals("/search")) {
			String search_string = request.getParameter("search");
			List<Category> categoryList = new ArrayList<Category>();
			List<Course> courseList = new ArrayList<Course>();
			try {
				categoryList = userService.searchByCategory(search_string);
				courseList = userService.searchByCourse(search_string);
				System.out.println(categoryList);
				System.out.println(courseList);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("categoryList",categoryList);	
			request.setAttribute("courseList", courseList);
			
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		}
		}
		
	
protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	PrintWriter pw = response.getWriter();

	String path = request.getPathInfo();

	if (path.equals("/list")) {
		try {
			List<Category> categories = userService.findCategory();
			request.setAttribute("categories", categories);

			request.getRequestDispatcher("/index.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println("error occurred: " + e.getMessage());
		}
	}
	if(path.equals("/search")) {
		String search_string = request.getParameter("search");
		List<Category> categoryList = new ArrayList<Category>();
		List<Course> courseList = new ArrayList<Course>();
		try {
			categoryList = userService.searchByCategory(search_string);
			courseList = userService.searchByCourse(search_string);
			System.out.println(categoryList);
			System.out.println(courseList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("categories",categoryList);	
		request.setAttribute("courseList", courseList);
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	if (path.equals("/open")) {
		try {
			

			request.getRequestDispatcher("/footer.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println("error occurred: " + e.getMessage());
		}
	}
}
}
