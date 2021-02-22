package com.cybage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cybage.model.Batch;
import com.cybage.model.Plan;
import com.cybage.model.Users;
import com.cybage.service.ManagerService;
import com.cybage.service.MemberService;

@ServletSecurity(
		value = @HttpConstraint(
				rolesAllowed = {"manager"}
				)
		) 
public class ManagerController extends HttpServlet {

	ManagerService ms = new ManagerService();
	MemberService memberService = new MemberService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);  
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("manager servlet");
		String path =  request.getPathInfo(); 
		
		
		if(path.equals("/addplan")) {
			try {
				Plan plan = new Plan();
				plan.setPlanname(request.getParameter("planname"));
				plan.setSportid(request.getParameter("sportsid"));
				plan.setFees(Double.parseDouble(request.getParameter("fees")));
				plan.setDuration(Integer.parseInt(request.getParameter("duration")));
				
				ms.addPlan(plan);
				response.sendRedirect("planlist");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		 
		if(path.equals("/planlist")) {
			try {
				request.setAttribute("plans", ms.getPlans());
 				request.getRequestDispatcher("/manager/plans.jsp").forward(request, response);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(path.equals("/deleteplan")) {
			try {
				ms.deletePlan(request.getParameter("planid"));
				response.sendRedirect("planlist");	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(path.equals("/editplan")) {
			try {
				System.out.println("path: "+ path);
				Plan plan = ms.getPlan(request.getParameter("planid"));
				request.setAttribute("plan", plan);
				request.getRequestDispatcher("/manager/edit-plan.jsp").include(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(path.equals("/updateplan")) {
			try {
				Plan plan = new Plan();
				plan.setPlanid(request.getParameter("planid"));
				plan.setPlanname(request.getParameter("planname"));
				plan.setSportid(request.getParameter("sportsid"));
				plan.setFees(Double.parseDouble(request.getParameter("fees")));
				plan.setDuration(Integer.parseInt(request.getParameter("duration")));
				System.out.println("inside controller: "+ plan);
				ms.updatePlan(plan);
				response.sendRedirect("planlist");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//batches 
		if(path.equals("/batchlist")) {
			try {
				request.setAttribute("batches", ms.getBatches());
 				request.getRequestDispatcher("/manager/batches.jsp").forward(request, response);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(path.equals("/addbatch")) {
			try {
				Batch batch = new Batch();
				batch.setBatchname(request.getParameter("batchname"));
				batch.setSportsid(request.getParameter("sportsid"));
				batch.setBatchStartDate(LocalDate.parse(request.getParameter("batchstartdate")));
				batch.setBatchTime(LocalTime.parse(request.getParameter("batchtime")));
				batch.setBatchDuration(Double.parseDouble(request.getParameter("batchduration")));
				batch.setBatchSize(Integer.parseInt(request.getParameter("batchsize")));
				ms.addBatch(batch);
				response.sendRedirect("batchlist");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(path.equals("/deletebatch")) {
			try {
				ms.deleteBatch(request.getParameter("batchid"));
				response.sendRedirect("batchlist");	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(path.equals("/editbatch")) {
			try {				 
				Batch batch = ms.getBatch(request.getParameter("batchid"));
				request.setAttribute("batch", batch);
				request.getRequestDispatcher("/manager/edit-batch.jsp").include(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(path.equals("/updatebatch")) {
			try { 
				Batch batch = new Batch();
				batch.setBatchid(request.getParameter("batchid"));
				batch.setBatchname(request.getParameter("batchname"));
				batch.setSportsid(request.getParameter("sportsid"));
				batch.setBatchStartDate(LocalDate.parse(request.getParameter("batchstartdate")));
				batch.setBatchTime(LocalTime.parse(request.getParameter("batchtime")));
				batch.setBatchDuration(Double.parseDouble(request.getParameter("batchduration")));
				batch.setBatchSize(Integer.parseInt(request.getParameter("batchsize")));			
				ms.updateBatch(batch);
				response.sendRedirect("batchlist");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(path.equals("/enrollments")) {
			try {
				request.setAttribute("enrollments", memberService.getEnrollments());
 				request.getRequestDispatcher("/manager/enrollments.jsp").forward(request, response);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
