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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		String uemail = request.getParameter("uemail");
		String ucon = request.getParameter("ucon");
		UserService us = new UserService();
		String status=us.registration(name, upwd, uemail, ucon);
		
		out.println("<html><body bg color='yellow'>");
		out.println("<center><br><br>");
		out.println("<font color='red' size='7'>");
		if(status.equals("sucess")) {
			out.println("Registration Sucess");
		}
		if(status.equals("existed")) {
			out.println("User Already Existed");
		}
		out.println("</font></center></body></html>");

		
	}

}
