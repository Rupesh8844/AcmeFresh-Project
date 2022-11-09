package com.acmefresh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acmefresh.model.CustomerSession;


@Repository
public interface CustomerSessionDao extends JpaRepository<CustomerSession, Integer>{
	
	public Optional<CustomerSession> findByCustomerId(Integer userId) ;
	
	public Optional<CustomerSession> findByUuid(String  uuid);

}
