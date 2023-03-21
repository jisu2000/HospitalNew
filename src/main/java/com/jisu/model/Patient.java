package com.jisu.model;

public class Patient {
	
	private int id;
	private String  name;
	private String email;
	private String cont;
	private String address;
	private String disease;
	private String doct;
	private String con;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getDoct() {
		return doct;
	}
	public void setDoct(String doct) {
		this.doct = doct;
	}
	public String getCon() {
		return con;
	}
	public void setCon(String con) {
		this.con = con;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", email=" + email + ", cont=" + cont + ", address=" + address
				+ ", disease=" + disease + ", doct=" + doct + ", con=" + con + "]";
	}
	public Patient(int id, String name, String email, String cont, String address, String disease, String doct,
			String con) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cont = cont;
		this.address = address;
		this.disease = disease;
		this.doct = doct;
		this.con = con;
	}
	public Patient() {
		super();
	}
	
	
	
	
	
	

}
