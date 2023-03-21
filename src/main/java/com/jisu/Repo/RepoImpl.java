package com.jisu.Repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.jisu.model.Booking;

public class RepoImpl implements BookingRepo {
	
	
	
	 private Connection connection;

	    public  RepoImpl(){

	        try{
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            String url="jdbc:mysql://localhost:3306/hospital";
	            String username="root";
	            String password="Jisu@2000";

	            connection= DriverManager.getConnection(url,username,password);

	        } catch (Exception e) {
	            
	        }
	    }

	    

   
	
    

    
	
	
	
	@Override
	public void addBooking(Booking book) {
		// TODO Auto-generated method stub
		String name=book.getName();
		String email=book.getEmail();
		String ph=book.getPhone();
		String dt=book.getDate();
		String msg=book.getMsg();
		
		
		String sql="INSERT INTO booking VALUES (?,?,?,?,?)";
		try {
			
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, ph);
			ps.setString(4, dt);
			ps.setString(5, msg);
			
			ps.executeUpdate();
			
		}
		catch( Exception e)
		{
			
		}
	
		
	}

	@Override
	public List<Booking> showall() {
		// TODO Auto-generated method stub
		return null;
	}

}
