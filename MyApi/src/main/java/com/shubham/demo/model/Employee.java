package com.shubham.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	
	private String firstName;
	private String lastName;
	@Id
	private String empId;
	private String email;
	private String mobileNumber;
	private String designation;
	
	public Employee(String firstName, String lastName, String empId, String email, String mobileNumber,
			String designation) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.empId = empId;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.designation = designation;
	}
	
	public Employee() {
		
	}

	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getMobilenumber() {
		return mobileNumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobileNumber = mobilenumber;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", designation=" + designation + ", mobilenumber=" + mobileNumber + "]";
	}
	
}
