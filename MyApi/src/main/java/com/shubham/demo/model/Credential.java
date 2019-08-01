package com.shubham.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Credential {
	@Id
	private String empId;
	private String password;
	private String security_Question;
	private String security_answer;
	public String getEmpId() {
		return empId;
	}
	public Credential() {
		
	}
	public void setE1(String empId) {
		this.empId=empId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSecurity_Question() {
		return security_Question;
	}
	public void setSecurity_Question(String security_Question) {
		this.security_Question = security_Question;
	}
	public String getSecurity_answer() {
		return security_answer;
	}
	public void setSecurity_answer(String security_answer) {
		this.security_answer = security_answer;
	}
	public Credential(String empId, String password, String security_Question, String security_answer) {
		super();
		this.empId = empId;
		this.password = password;
		this.security_Question = security_Question;
		this.security_answer = security_answer;
	}
	@Override
	public String toString() {
		return "Credential [empId=" + empId + ", password=" + password + ", security_Question=" + security_Question
				+ ", security_answer=" + security_answer + "]";
	}
	
}
