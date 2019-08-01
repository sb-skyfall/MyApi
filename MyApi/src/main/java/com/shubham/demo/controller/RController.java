package com.shubham.demo.controller;

import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shubham.demo.dao.CredentialDao;
import com.shubham.demo.dao.EmployeeDao;
import com.shubham.demo.model.Credential;
import com.shubham.demo.model.Email;
import com.shubham.demo.model.EmpData;
import com.shubham.demo.model.Employee;
import com.shubham.demo.model.ServiceResponse;

@Controller
public class RController {

	@Autowired
	EmployeeDao ed;
	@Autowired
	CredentialDao cd;
	@Autowired
	HttpServletRequest req;
	@Autowired
	HttpServletResponse res;
	TreeMap<String,Employee> sess=new TreeMap<>();
	
	@RequestMapping("/reg")
	public String Handle()
	{
		if(sess.size()==0)
		{
			return "Registration.html";
			
		}
		return "welcome.html";
	}
	@RequestMapping("/login")
	public String loggingin()
	{
		if(sess.size()==0)
		{
			return "login.html";
			
		}
		return "welcome.html";
	}
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<Object> response(@RequestBody EmpData e)
	{
		//System.out.println(e.getDesignation()+e.getEmail()+e.getEmpId()+e.getFirstName()+e.getLastName()+e.getMobileNumber()+e.getPassword()+e.getSecurity_answer()+e.getSecurity_Question());
		ServiceResponse<EmpData> response = new ServiceResponse<>("success",e);
		
		Employee e1=new Employee(e.getFirstName(),e.getLastName(),e.getEmpId(),e.getEmail(),e.getMobileNumber(),e.getDesignation());
		Credential c=new Credential(e.getEmpId(),e.getPassword(),e.getSecurity_Question(),e.getSecurity_answer());
		ed.save(e1);
		cd.save(c);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
	@RequestMapping(value="/checkStatus")
	public String loggingin(@RequestParam("empId") String empId,@RequestParam("pwd") String password)
	{
		
		System.out.println(empId+password);
		Credential c=cd.findByLoginInfo(empId,password);
		String status="failure";
		//System.out.println(empId+" "+password);
		if(c!=null)
		{
			System.out.println("Found");
			Employee e=ed.findByEmpId(empId);
			sess.put(c.getEmpId(),e);
			ServiceResponse<Credential> response = new ServiceResponse<>("success",c);
			return "welcome.html";
		}
		ServiceResponse<Credential> response = new ServiceResponse<>("failure",c);
		return "login.html";
	}
	@PostMapping("/searchEmail")
	public ResponseEntity<Object> searchViaEmail(@RequestBody Email email) 
	{
		System.out.println(email.getEmail());
		
		Employee e=ed.findByEmail(email.getEmail());
		String st="failure";
		System.out.println(e);
		if(null!=e)
		{
			ServiceResponse<Employee> res=new ServiceResponse<>("success",e);
			System.out.println("Entered");
			return new ResponseEntity<Object>(res,HttpStatus.OK);
			
		}
		ServiceResponse<Employee> res=new ServiceResponse<>(st,e);
		return new ResponseEntity<Object>(res,HttpStatus.OK);
		
	}
	@GetMapping("/logout")
	public String loggingout()
	{
		sess.clear();
		return "login.html";
	}
}
