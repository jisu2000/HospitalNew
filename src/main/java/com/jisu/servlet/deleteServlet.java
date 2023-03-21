package com.jisu.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jisu.Repo.MySQLDao;

/**
 * Servlet implementation class deleteServlet
 */
@WebServlet("/delete")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		
		
		RequestDispatcher rs=null;
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		MySQLDao service=new MySQLDao();
		boolean flag=service.delete(id);
		
		rs=request.getRequestDispatcher("admin.jsp");
		
		if(flag)
		{
			response.sendRedirect("layout-static.jsp");
			request.setAttribute("status", "success");
		}
		else {
			response.sendRedirect("layout-static.jsp");
		}
		
	
	}
	
	
	

}
