package com.jisu.Repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jisu.model.Booking;
import com.jisu.model.Doctor;
import com.jisu.model.Patient;

public class MySQLDao {

	public Connection conn;

	public MySQLDao() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/hospital";
			String username = "root";
			String password = "Jisu@2000";

			conn = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException();
		}

	}

	public void closeConnection() {

		try {
			conn.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Booking> viewAll() {

		try {

			List<Booking> list = new ArrayList<>();
			String sql = "SELECT * FROM booking";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next())

			{

				Booking book = new Booking();

				book.setId(rs.getInt(1));
				book.setName(rs.getString(2));
				book.setEmail(rs.getString(3));
				book.setPhone(rs.getString(4));
				book.setDate(rs.getString(5));
				book.setMsg(rs.getString(6));

				list.add(book);

			}

			return list;

		}

		catch (Exception e) {

		}

		return null;
	}

	public List<Doctor> viewAllDoct() {

		try {

			List<Doctor> list = new ArrayList<>();
			String sql = "SELECT * FROM doctor";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			Doctor dr = null;
			while (rs.next())

			{
				dr = new Doctor();

				dr.setId(rs.getInt(1));
				dr.setName(rs.getString(2));
				dr.setEmail(rs.getString(3));
				dr.setCont(rs.getString(4));
				dr.setAddress(rs.getString(5));
				dr.setQual(rs.getString(6));

				list.add(dr);

			}
			conn.close();
			return list;

		}

		catch (Exception e) {

		}

		return null;
	}

	public Booking getBookingId(int id) {
		Booking book = null;

		try {

			String sql = "SELECT * FROM booking WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next())

			{

				book = new Booking();

				book.setId(rs.getInt(1));
				book.setName(rs.getString(2));
				book.setEmail(rs.getString(3));
				book.setPhone(rs.getString(4));
				book.setDate(rs.getString(5));
				book.setMsg(rs.getString(6));

			}

			return book;

		}

		catch (Exception e) {

		}

		return null;

	}

	public boolean delete(int id) {
		boolean f = false;

		try {

			String sql = "DELETE from booking where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		}

		catch (Exception e) {

		}

		return f;

	}

	public Doctor getdoctbyId(int id) {
		Doctor dr = null;

		try {

			String sql = "SELECT * FROM doctor WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next())

			{

				dr = new Doctor();
				dr.setId(rs.getInt(1));
				dr.setName(rs.getString(2));
				dr.setEmail(rs.getString(3));
				dr.setCont(rs.getString(4));
				dr.setAddress(rs.getString(5));
				dr.setQual(rs.getString(6));

			}

			return dr;

		}

		catch (Exception e) {

		}

		return null;

	}

	public boolean deletedoct(int id) {
		boolean f = false;

		try {

			String sql = "DELETE from doctor where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		}

		catch (Exception e) {

		}

		return f;

	}

	public boolean Updatedoct(Doctor doct) {
		boolean f = false;

		try {

			String sql = "UPDATE doctor set name=?,email=?,phoneno=?,address=?,qual=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, doct.getName());
			ps.setString(2, doct.getEmail());
			ps.setString(3, doct.getCont());
			ps.setString(4, doct.getAddress());
			ps.setString(5, doct.getQual());
			ps.setInt(6, doct.getId());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		}

		catch (Exception e) {

		}

		return f;

	}

//	public boolean addPatient(Patient p)
//	{
//		boolean f=false;
//		
//		
//		
//		
//		
//	}

	public boolean addPatient(Patient p)

	{
		boolean f = false;

		try {

			PreparedStatement ps = conn.prepareStatement(
					"INSERT into patient(name,email,contact,address,disease,doctor,con) VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, p.getName());
			ps.setString(2, p.getEmail());
			ps.setString(3, p.getCont());
			ps.setString(4, p.getAddress());
			ps.setString(5, p.getDisease());
			ps.setString(6, p.getDoct());
			ps.setString(7, p.getCon());

			int row = ps.executeUpdate();

			if (row > 0) {
				f = true;
			} else {
				f = false;
			}

		}

		catch (Exception e) {

		}

		return f;

	}

	public List<Patient> viewAllpat() {
		Patient pt = null;
		try {

			List<Patient> list = new ArrayList<>();
			String sql = "SELECT * FROM patient";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next())

			{
				pt = new Patient();
				pt.setId(rs.getInt(1));
				pt.setName(rs.getString(2));
				pt.setEmail(rs.getString(3));
				pt.setCont(rs.getString(4));
				pt.setAddress(rs.getString(5));
				pt.setDisease(rs.getString(6));
				pt.setDoct(rs.getString(7));
				pt.setCon(rs.getString(8));

				list.add(pt);

			}

			return list;

		}

		catch (Exception e) {

		}

		return null;
	}

	public boolean deletePt(int id) {
		boolean f = false;

		try {

			String sql = "DELETE from patient where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		}

		catch (Exception e) {

		}

		return f;

	}

	public Patient findptId(int id) {

		Patient pt = null;

		try {

			String sql = "SELECT * FROM patient WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next())

			{

				pt = new Patient();
				pt.setId(rs.getInt(1));
				pt.setName(rs.getString(2));
				pt.setEmail(rs.getString(3));
				pt.setCont(rs.getString(4));
				pt.setAddress(rs.getString(5));
				pt.setDisease(rs.getString(6));
				pt.setDoct(rs.getString(7));
				pt.setCon(rs.getString(8));

			}

			return pt;

		}

		catch (Exception e) {

		}

		return null;
	}
	
	
	
	public boolean UpdatePet(Patient pt) {
		boolean f = false;

		try {

			String sql = "UPDATE patient SET name=?,email=?,contact=?,address=?,disease=?,doctor=?,con=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pt.getName());
			ps.setString(2, pt.getEmail());
			ps.setString(3, pt.getCont());
			ps.setString(4, pt.getAddress());
			ps.setString(5, pt.getDisease());
			ps.setString(6, pt.getDoct());
			ps.setString(7, pt.getCon());
			ps.setInt(8, pt.getId());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		}

		catch (Exception e) {

		}

		return f;

	}
	
	
	

}
