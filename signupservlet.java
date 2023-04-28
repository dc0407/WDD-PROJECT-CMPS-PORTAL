package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signin
 */
@WebServlet("/signin")
public class signupservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw =response.getWriter();
		response.setContentType("text/html");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phoneno=request.getParameter("phone number");
		String password=request.getParameter("password");
		// RequestDispatcher dispatcher=null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?useSSL=false","root","Dc@04072002");
			
			java.sql.PreparedStatement ps = connection.prepareStatement("INSERT INTO `login` .`user` (`email`,`password`,`name`,`phone number`) VALUES (?,?,?,?);");
			
			ps.setString(1, email);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.setString(4, phoneno);
		
			int row = ps.executeUpdate();
			// dispatcher = request.getRequestDispatcher("signin.jsp");
	        if (row > 0) {
	        	response.sendRedirect("signup.html");
	        	// request.setAttribute("status","success");
	        	
	        }
	        else {
	        // 	request.setAttribute("status" , "failed");
	        	response.sendRedirect("https://www.youtube.com/watch?v=YvPGeUkafHs");
	        }
	      //  dispatcher.forward(request, response);
			connection.close();
		}
		catch(SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

