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

@WebServlet("/user/Second")
public class Second extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Second() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.print("this is second servlet (get)");
		
//		Cookie[] cookies = request.getCookies();
//		
//		for(Cookie c : cookies) {
//			if(c.getName().equals("un")) {
//				pw.print("username : "+ c.getValue());		
//			}
//		}
		HttpSession session = request.getSession();
		pw.print("Welcome: "+  session.getAttribute("username"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.print("this is second servlet (post)");
		
	}
}