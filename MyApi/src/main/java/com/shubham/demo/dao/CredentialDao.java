package com.shubham.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shubham.demo.model.Credential;
public interface CredentialDao extends JpaRepository<Credential,Integer>{

	@Query("from Credential where empId=?1 and password=?2")
	Credential findByLoginInfo(String empId,String password);
}
