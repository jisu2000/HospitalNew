package com.jisu.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jisu.Repo.MySQLDao;
import com.jisu.model.Doctor;

/**
 * Servlet implementation class UpdateDr
 */
@WebServlet("/updatedr")
public class UpdateDr extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String contact=request.getParameter("cont");
		String address=request.getParameter("address");
		String qual=request.getParameter("qual");
		
		
		int id=Integer.parseInt(request.getParameter("id"));
		MySQLDao service=new MySQLDao();
		
		Doctor dr=new Doctor(id,name,email,contact,address,qual);
		
	
		
		
	HttpSession session=request.getSession();
		
		
		boolean f=service.Updatedoct(dr);
		
		if(f)
		{
			session.setAttribute("success", "Operation successful");
			response.sendRedirect("showdoct.jsp");
		}
		else
		{
			session.setAttribute("error", "Something went wrong");
			response.sendRedirect("showdoct.jsp");
		}
		
		
		
		
	}

}
