package com.jisu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jisu.model.Booking;
import com.jisu.model.Doctor;

/**
 * Servlet implementation class AddDoct
 */
@WebServlet("/adddoct")
public class AddDoct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		String name=(String)request.getParameter("name");
		String email=(String)request.getParameter("email");
		String ph=(String)request.getParameter("cont");
		String add=(String)request.getParameter("address");
		String qual=(String)request.getParameter("qual");
		
		Doctor dt=new Doctor(name,email,ph,add,qual);
//		
//		PrintWriter out=response.getWriter();
//		
//		out.println(dt);
		
//		Booking book=new Booking();
//		book.setName(name);
//		book.setEmail(email);
//		book.setPhone(ph);
//		book.setDate(dt);
//		book.setMsg(msg);
		
		
		
		  
		RequestDispatcher rs=null;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","Jisu@2000");
			rs=request.getRequestDispatcher("index.jsp");
			PreparedStatement ps=con.prepareStatement("INSERT into doctor(name,email,phoneno,address,qual) VALUES (?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, ph);
			ps.setString(4, add);
			ps.setString(5, qual);
			rs=request.getRequestDispatcher("adddoct.jsp");

			
			int row=ps.executeUpdate();
			
			if(row>0)
			{
				
				response.sendRedirect("showdoct.jsp");
				request.setAttribute("status", "success");
			
				
				
				
			}
			
			else {
				
				response.sendRedirect("showdoct.jsp");
			request.setAttribute("status", "failed");			}
			rs.forward(request, response);
		}
		
		catch(Exception e)
		{
			
		}
		
		
		
		
		
	
		
	
	
		
		
		
		
		
		
	}

}
