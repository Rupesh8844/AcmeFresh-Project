package com.acmefresh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acmefresh.model.CurrentAdminSession;

public interface AdminSessionDao extends JpaRepository<CurrentAdminSession, Integer>{
	
	public Optional<CurrentAdminSession> findByAdminId(Integer userId) ;
	
	public Optional<CurrentAdminSession> findByUuid(String  uuid);

}
