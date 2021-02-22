package com.cybage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.model.Enrollment;
import com.cybage.model.Users;
import com.cybage.service.MemberService;

public class MemberController extends HttpServlet {

	MemberService ms = new MemberService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	} 


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String path =  request.getPathInfo(); 
		if(path.equals("/planlist")) {
			try {
				request.setAttribute("plans", ms.getPlans());
				request.getRequestDispatcher("/member/plans.jsp").forward(request, response);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if(path.equals("/enroll")) {
			try {
				request.setAttribute("planid", request.getParameter("planid"));
				request.getRequestDispatcher("/member/enroll.jsp").forward(request, response);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(path.equals("/makeenrollment")) {
			try {
				Enrollment enroll = new Enrollment();
				enroll.setUsername("user");
				enroll.setBatchid(request.getParameter("batchid"));
				enroll.setPlanid(request.getParameter("planid"));
				enroll.setStartdate(LocalDate.parse(request.getParameter("startdate")));
				ms.enroll(enroll);
				request.getRequestDispatcher("/member/enroll.jsp").forward(request, response);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(path.equals("/enrollments")) {
			try {
				request.setAttribute("enrollments", ms.getEnrollments());
				request.getRequestDispatcher("/member/enrollments.jsp").forward(request, response);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if(path.equals("/register")) {
			try {
				System.out.println("inside registration");
				Users user = new Users(request.getParameter("username"), request.getParameter("password"), "member");
				ms.register(user);
				out.print("Registration successful...");
				request.getRequestDispatcher("/index.jsp").include(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
