package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginservlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{ 

        PrintWriter pw =res.getWriter();
        res.setContentType("text/html");
        String name= req.getParameter("email");
        String pwd = req.getParameter("password");
        boolean status=false;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/login?useSSL=false","root","Dc@04072002");

            java.sql.PreparedStatement ps = connection.prepareStatement("select * from user where email = ? and password = ?");
            ps.setString(1, name);
            ps.setString(2, pwd);
            System.out.println(ps);
            ResultSet rs=ps.executeQuery();
            status=rs.next();
        }
        catch(SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }

        if(status) {
            // Redirect to homepage.html upon successful login
            res.sendRedirect("homepage.html");
        }
        else {
    
                pw.print("<p style=color:red>Username and Password invalid</p>");
                pw.print("<form action=\"signup.html\"><button type=\"submit\">Signup</button></form>");
            }

        }
    

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{ 
        doGet(req,res);
    }
}
