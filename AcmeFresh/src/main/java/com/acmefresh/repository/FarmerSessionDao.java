package com.acmefresh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acmefresh.model.FarmerSession;


@Repository
public interface FarmerSessionDao extends JpaRepository<FarmerSession, Integer>{

	public Optional<FarmerSession> findByClientId(Integer userId) ;
	
	public Optional<FarmerSession> findByUuid(String  uuid);

}
