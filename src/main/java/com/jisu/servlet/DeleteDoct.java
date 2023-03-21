package com.jisu.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jisu.Repo.MySQLDao;

/**
 * Servlet implementation class DeleteDoct
 */
@WebServlet("/deletedoct")
public class DeleteDoct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		RequestDispatcher rs=null;
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		MySQLDao service=new MySQLDao();
		boolean flag=service.deletedoct(id);
		
		rs=request.getRequestDispatcher("admin.jsp");
		
		if(flag)
		{
			response.sendRedirect("showdoct.jsp");
			request.setAttribute("status", "success");
		}
		else {
			response.sendRedirect("showdoct.jsp");
		}
		
		
		
	}

	

}
