package com.jisu.model;

public class Booking {
	private String name;
	private String email;
	private String phone;
	private String date;
	private String msg;
	private int  id;
	
	
	
	public Booking(String name, String email, String phone, String date, String msg, int id) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.date = date;
		this.msg = msg;
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Booking() {
		
	}
	public Booking(String name, String email, String phone, String date, String msg) {
		
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.date = date;
		this.msg = msg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "Booking [name=" + name + ", email=" + email + ", phone=" + phone + ", date=" + date + ", msg=" + msg
				+ "]";
	}
	
	
	
	
}
