package com.acmefresh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acmefresh.model.Farmer;


@Repository
public interface FarmerDao extends JpaRepository<Farmer, Integer>{
	
public Optional<Farmer> findByUsername(String username) ;
	
	public Optional<Farmer> findByMobile(String username) ;
}
