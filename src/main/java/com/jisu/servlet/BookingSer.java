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

import com.jisu.Repo.BookingRepo;
import com.jisu.Repo.RepoImpl;
import com.jisu.model.Booking;

/**
 * Servlet implementation class Booking
 */
@WebServlet("/booking")
public class BookingSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name=(String)request.getParameter("name");
		String email=(String)request.getParameter("email");
		String ph=(String)request.getParameter("phone");
		String dt=(String)request.getParameter("date");
		String msg=(String)request.getParameter("message");
		
//		Booking book=new Booking();
//		book.setName(name);
//		book.setEmail(email);
//		book.setPhone(ph);
//		book.setDate(dt);
//		book.setMsg(msg);
		
		Booking book=new Booking(name, email, ph, dt, msg);
		
		  
		RequestDispatcher rs=null;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","Jisu@2000");
			rs=request.getRequestDispatcher("index.jsp");
			PreparedStatement ps=con.prepareStatement("INSERT into booking(name,email,phoneno,date,msg) VALUES (?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, ph);
			ps.setString(4, dt);
			ps.setString(5, msg);
			rs=request.getRequestDispatcher("index.jsp");

			
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
