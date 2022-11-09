package com.acmefresh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acmefresh.model.Client;

public interface ClientDao extends JpaRepository<Client, Integer>{
	
public Optional<Client> findByUsername(String username) ;
	
	public Optional<Client> findByMobile(String username) ;
}
