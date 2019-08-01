package com.shubham.demo.model;

public class Pair {
	private String empId;
	private String password;
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String pwd) {
		this.password = pwd;
	}
	public Pair() {
		super();
	}
	public Pair(String empId, String password) {
		super();
		this.empId = empId;
		this.password= password;
	}
	
}
