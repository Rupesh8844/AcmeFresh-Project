package com.acmefresh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acmefresh.model.CurrentClientSession;

public interface ClientSessionDao extends JpaRepository<CurrentClientSession, Integer>{

	public Optional<CurrentClientSession> findByClientId(Integer userId) ;
	
	public Optional<CurrentClientSession> findByUuid(String  uuid);

}
