package com.shubham.demo.dao;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shubham.demo.model.Employee;

public interface EmployeeDao extends JpaRepository<Employee,Integer> {
	@Query(value="select *  from Employee e where e.email=:email",nativeQuery=true)
	public Employee findByEmail(@Param("email") String email);
	public ArrayList<Employee> findByDesignation(String designation);
	public Employee findByEmpId(String empId);
}
