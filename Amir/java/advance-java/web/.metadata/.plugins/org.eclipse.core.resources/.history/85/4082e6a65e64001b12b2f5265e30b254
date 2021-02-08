package com.cybage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Second extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Second() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.print("<h1>This is get method (second) </h1>");

		// getting servlet context information
		ServletContext context = getServletContext();
		System.out.println("org name : " + context.getInitParameter("appname"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.print("<h1>This is get method  (second)</h1>");
		String username = request.getParameter("username");
		System.out.println("username from user(second): " + username);
	}

}
