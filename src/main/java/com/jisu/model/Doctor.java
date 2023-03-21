package com.jisu.model;

public class Doctor {
	
	private Integer id;
	private String name;
	private String email;
	private String cont;
	private String address;
	private String qual;
	
	
	
	
	
	public Doctor() {
	
	}
	
	
	
	
	
	public Doctor(Integer id, String name, String email, String cont, String address, String qual) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cont = cont;
		this.address = address;
		this.qual = qual;
	}


	



	public Doctor(String name, String email, String cont, String address, String qual) {
		super();
		this.name = name;
		this.email = email;
		this.cont = cont;
		this.address = address;
		this.qual = qual;
	}





	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getQual() {
		return qual;
	}
	public void setQual(String qual) {
		this.qual = qual;
	}





	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", email=" + email + ", cont=" + cont + ", address=" + address
				+ ", qual=" + qual + "]";
	}
	
	
	
	
	
	
	
	
}
