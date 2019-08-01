package com.shubham.demo.model;



public class EmpData {
	private String firstName;
	private String lastName;
	
	private String empId;

	private String email;
	private String mobileNumber;
	private String designation;
	private String password;
	private String security_Question;
	private String security_answer;
	public EmpData(String firstName, String lastName, String empId, String email, String mobileNumber,
			String designation, String password, String security_Question, String security_answer) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.empId = empId;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.designation = designation;
		this.password = password;
		this.security_Question = security_Question;
		this.security_answer = security_answer;
	}
	@Override
	public String toString() {
		return "EmpData [firstName=" + firstName + ", lastName=" + lastName + ", empId=" + empId + ", email=" + email
				+ ", mobileNumber=" + mobileNumber + ", designation=" + designation + ", password=" + password
				+ ", security_Question=" + security_Question + ", security_answer=" + security_answer + "]";
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
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
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
	

}
