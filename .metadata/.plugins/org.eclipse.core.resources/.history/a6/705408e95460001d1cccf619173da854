package com.acmefresh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acmefresh.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{
	
	public Optional<Customer> findByUsername(String username) ;
	
	public Optional<Customer> findByMobile(String username) ;
}
