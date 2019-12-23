package com.login.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.service.UserService;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		UserService us = new UserService();
		String status=us.checkLogin(uname,upwd);
		out.println("<html><body bgcolor='yellow'>");
		out.println("<center><br><br>");
		out.println("<font color='red' size='7'>");
		if(status.equals("sucess")) {
			out.println("LOGIN SUCESS");
		}
		if(status.equals("failure")) {
			out.println("LOGIN FAILURE..!!");
		}
		out.println("</font></center></body></html>");
		}

}
