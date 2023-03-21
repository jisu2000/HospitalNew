package com.jisu.registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uemail=request.getParameter("lemail");
		String upass=request.getParameter("lpass");
		HttpSession session=request.getSession();
		RequestDispatcher ds =null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","Jisu@2000");
			
			PreparedStatement ps=con.prepareStatement("SELECT * FROM admin where aemail=? AND apass=?");
			ps.setString(1, uemail);
			ps.setString(2, upass);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				session.setAttribute("name", rs.getString("aname"));
				session.setAttribute("email",uemail );
				ds=request.getRequestDispatcher("admin.jsp");
				
			}
			
			else {
				request.setAttribute("status", "failed");
				ds=request.getRequestDispatcher("login.jsp");
				
			}
			ds.forward(request, response);
		}
		catch(Exception e) {
			
		}
		
		
		
	}

}
