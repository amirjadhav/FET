package com.cybage.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cybage.dao.SubCourseDao;
import com.cybage.dao.SubCourseDaoImpl;
import com.cybage.dao.UserDao;
import com.cybage.dao.UserDaoImpl;
import com.cybage.exception.UserException;
import com.cybage.model.SubCourse;
import com.cybage.model.User;
import com.cybage.service.SubCourseService;
import com.cybage.service.SubCourseServiceImpl;
import com.cybage.service.UserService;
import com.cybage.service.UserServiceImpl;

//@ServletSecurity(value = @HttpConstraint(rolesAllowed = { "user" }))
public class UserController extends HttpServlet {

	public static final Logger log = LogManager.getLogger(UserController.class);

	private UserDao userDao = new UserDaoImpl();

	private UserService userService = new UserServiceImpl(userDao);

	private SubCourseDao subCourseDao = new SubCourseDaoImpl();

	private SubCourseService subCourseService = new SubCourseServiceImpl(subCourseDao);

	private static final long serialVersionUID = 1L;

	public UserController() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, UserException {

		PrintWriter pw = response.getWriter();
		String path = request.getPathInfo();
//		System.out.println("inside get method");
//		System.out.println("path:" + path);
//		System.out.println("path:" + path.substring(14));
		int currentVideo = Integer.parseInt(path.substring(14));

		if (path.substring(0, 13).equals("/start-course")) {
		//	System.out.println("inside nextvideo method");
			log.debug("inside nextvideo method....");

			List<SubCourse> subcourses = null;

			try {
				subcourses = subCourseService.findSubCourse();
				request.getSession().setAttribute("video_count", subcourses.size());
				request.getSession().setAttribute("current_video", currentVideo);
			//	System.out.println("size of subcourses" + subcourses.size());
				if (subcourses.size() == 0) {
					throw new UserException("No SubCourse found in database...");
				}
			//	System.out.println(subcourses.get(currentVideo-1));
				
				
				request.getSession().setAttribute("subcourse_id", subcourses.get(currentVideo-1).getSubCourseId());
				request.getSession().setAttribute("subcourse_title",subcourses.get(currentVideo-1).getSubCourseName());
				request.getSession().setAttribute("subcourse_desc", subcourses.get(currentVideo-1).getSubCourseDescription());
				
				response.sendRedirect(request.getContextPath() + "/start-course.jsp");
				
			} catch (SQLException e) {
				log.error("could not get Subcourse: " + e.getMessage());
			}
		}

		if (path.equals("/list")) {
			log.debug("inside list method....");
			List<User> users = null;
			try {
				users = userService.findUser();
				if (users.size() == 0) {
					throw new UserException("No user found in database...");
				}
				request.setAttribute("users", users);
				request.getRequestDispatcher("/user/view-user.jsp").forward(request, response);
			} catch (SQLException e) {
				log.error("could not get users: " + e.getMessage());
			}
		}

		if (path.equals("/delete")) {
			log.debug("inside delete method....");
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				int deleteCount = userService.deleteUser(id);
				if (deleteCount <= 0) {
					throw new UserException("could not delete user");
				}
				response.sendRedirect("list");

			} catch (SQLException e) {
				log.error("error occurred: " + e.getMessage());
			}
		}
		if (path.equals("/add")) {
			System.out.println("inside add method");
			log.debug("inside add method....");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String address = request.getParameter("address");

			User user = new User(username, password, address, "user");

			try {
				int addCount = userService.addUer(user);
				if (addCount <= 0) {
					throw new UserException("could not add user");
				}

				response.sendRedirect("list");

			} catch (SQLException e) {
				log.error("exception occurred... " + e.getLocalizedMessage());
			}
		}
		if (path.equals("/edit")) {
			log.debug("inside edit method....");
			try {
				int id = Integer.parseInt(request.getParameter("id"));
				User user = userService.findUserById(id);

				if (user == null) {
					throw new UserException("could not get given user");
				}

				request.setAttribute("user", user);
				request.getRequestDispatcher("/user/edit-user.jsp").forward(request, response);

			} catch (SQLException e) {
				log.error("error occurred: " + e.getMessage());
			}
		}
//		actual updation happens here...
		if (path.equals("/edit-user")) {
			log.debug("inside edit-user method....");
			int id = Integer.parseInt(request.getParameter("id"));
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String address = request.getParameter("address");
			String role = request.getParameter("role");

			User user = new User(id, username, password, address, role);
			try {
				int updateCount = userService.udpateUser(user);
				if (updateCount <= 0) {
					throw new UserException("could not update user");
				}
				response.sendRedirect("list");

			} catch (SQLException e) {
				log.error("exception occurred... " + e.getLocalizedMessage());
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}