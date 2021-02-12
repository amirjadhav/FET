package com.cybage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/user/First")
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public First() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.print("this is first servlet (get)");
		response.setContentType("text/html");
//        //storing data in cookies
//        Cookie cookie = new Cookie("un", "dmjadhav");
//        response.addCookie(cookie);

		// get value from session using httpsession
		HttpSession session = request.getSession();
		pw.println("<br> Welcome: " + session.getAttribute("username"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.print("this is first servlet (post)");
	}
}