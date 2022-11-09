package com.acmefresh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acmefresh.model.CurrentCustomerSession;

public interface CustomerSessionDao extends JpaRepository<CurrentCustomerSession, Integer>{
	
	public Optional<CurrentCustomerSession> findByCustomerId(Integer userId) ;
	
	public Optional<CurrentCustomerSession> findByUuid(String  uuid);

}
