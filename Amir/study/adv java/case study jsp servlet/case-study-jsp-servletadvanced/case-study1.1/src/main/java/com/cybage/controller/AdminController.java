package com.cybage.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.dao.UserDao;
import com.cybage.model.Users;
import com.cybage.service.UserService;



@ServletSecurity(
		value = @HttpConstraint(
				rolesAllowed = {"admin"}
				)  
		)
public class AdminController extends HttpServlet {
	UserService us = new UserService();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);  
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("admin servlet");
		String path =  request.getPathInfo(); 
		
		
		if(path.equals("/add")) {
			try {
				Users user = new Users();
				user.setUsername(request.getParameter("username"));
				user.setPassword(request.getParameter("password"));
				user.setRole(request.getParameter("userrole"));
				us.addUser(user);
				response.sendRedirect("list");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(path.equals("/edit")) {
			try {
				System.out.println("path: "+ path);
				Users user = us.getUser(request.getParameter("un"));
				System.out.println("user details: "+ user);
				request.setAttribute("user", user);
				request.getRequestDispatcher("/admin/admin-update-user.jsp").include(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(path.equals("/update")) {
			try {
				Users user = new Users();
				user.setUsername(request.getParameter("username"));
				user.setPassword(request.getParameter("password"));
				user.setRole(request.getParameter("userrole"));
				us.updateUser(user);
				response.sendRedirect("list");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(path.equals("/list")) {
			try {
				request.setAttribute("users", us.getUsers());
 				request.getRequestDispatcher("/admin/admin-user-management.jsp").forward(request, response);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(path.equals("/delete")) {
			try {
				us.deleteUser(request.getParameter("un"));
				response.sendRedirect("list");	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
