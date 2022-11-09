package com.acmefresh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acmefresh.model.ClientSession;


@Repository
public interface ClientSessionDao extends JpaRepository<ClientSession, Integer>{

	public Optional<ClientSession> findByClientId(Integer userId) ;
	
	public Optional<ClientSession> findByUuid(String  uuid);

}
