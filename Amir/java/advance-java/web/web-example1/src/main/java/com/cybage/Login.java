package com.cybage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/user/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();

		// will check username , password is correct or not
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username.equals("admin") && password.equals("admin")) {
			// if success then will go to welcome.jsp
			HttpSession session = request.getSession();
			session.setAttribute("username", username);

			request.getRequestDispatcher("/Welcome.jsp").forward(request, response);

		} else {
			// if failure then will go to index.jsp
			pw.print("<h3 style=color:red>incorrect username/password  </h3>");
			request.getRequestDispatcher("/index.jsp").include(request, response);
		}
	}

}