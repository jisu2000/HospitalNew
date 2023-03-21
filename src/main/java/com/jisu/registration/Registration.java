package com.jisu.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.*;
import java.sql.PreparedStatement;
import com.email.durgesh.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/register")
		
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=request.getParameter("Username");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		RequestDispatcher rs=null;
		
	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","Jisu@2000");
			rs=request.getRequestDispatcher("signup.jsp");
			PreparedStatement ps=con.prepareStatement("INSERT into admin(aname,aemail,apass) VALUES (?,?,?)");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			
			
			int row=ps.executeUpdate();
			
			if(row>0)
			{
				request.setAttribute("status", "success");
				
			
				
				
			}
			
			else {
				request.setAttribute("status", "failed");
			}
			rs.forward(request, response);
		}
		
		catch(Exception e)
		{
			
		}
		
	}

}
