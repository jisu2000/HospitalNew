package com.jisu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jisu.Repo.MySQLDao;

/**
 * Servlet implementation class Deletept
 */
@WebServlet("/deletept")
public class Deletept extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	MySQLDao service=new MySQLDao();
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		boolean f=service.deletePt(id);
		
		
		if(f)
		{
			response.sendRedirect("showallpat.jsp");
		}
		else {
			
			response.sendRedirect("showallpat.jsp");
			
			
		}
	}

}
