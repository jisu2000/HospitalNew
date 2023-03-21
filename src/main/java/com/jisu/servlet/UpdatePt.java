package com.jisu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jisu.Repo.MySQLDao;
import com.jisu.model.Patient;

/**
 * Servlet implementation class UpdatePt
 */
@WebServlet("/updatept")
public class UpdatePt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		MySQLDao service=new MySQLDao();
		boolean f=false;
		String name= (String) request.getParameter("name");
		String email=(String)request.getParameter("email");
		String cont=(String)request.getParameter("cont");
		String add=(String)request.getParameter("address");
		String diss=(String)request.getParameter("dis");
		
		String doct=(String)request.getParameter("doct");
		String conn= (String) request.getParameter("con");
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		
		Patient p=new Patient(id,name,email,cont,add,diss,doct,conn);
		
		
		
		
	
	
		
		
		
		
		f=service.UpdatePet(p);
		
		if(f)
		{
			response.sendRedirect("showallpat.jsp");
		}
		
		else {
			response.sendRedirect("showallpat.jsp");
		}
		
	
		
		
		
		
		
		
	}

}
