package com.acmefresh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acmefresh.model.Admin;



@Repository
public interface AdminDao extends JpaRepository<Admin, Integer>{

public Optional<Admin> findByUsername(String username) ;
	
	public Optional<Admin> findByMobile(String username) ;
	
}
