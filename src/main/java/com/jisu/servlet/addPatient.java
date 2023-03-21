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

import com.jisu.Repo.MySQLDao;
import com.jisu.model.Patient;

/**
 * Servlet implementation class addPatient
 */
@WebServlet("/addpatient")
public class addPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name= (String) request.getParameter("name");
		String email=(String)request.getParameter("email");
		String cont=(String)request.getParameter("cont");
		String add=(String)request.getParameter("address");
		String diss=(String)request.getParameter("dis");
		
		String doct=(String)request.getParameter("doct");
		String conn= (String) request.getParameter("con");
		
		Patient p=new Patient();
		p.setName(name);
		p.setAddress(add);
		p.setCon(conn);
		p.setDoct(doct);
		p.setEmail(email);
		p.setCont(cont);
		p.setDisease(diss);
	
		
//		System.out.println(p.toString());
		
		MySQLDao service=new MySQLDao();
		
		boolean f=service.addPatient(p);
		
		if(f)
		{
			response.sendRedirect("showallpat.jsp");
		}
		else {
			response.sendRedirect("showallpat.jsp");
		}
		  

				
				
				
				
		
		
		
		
	
		
		
		
		
		
	}

}
