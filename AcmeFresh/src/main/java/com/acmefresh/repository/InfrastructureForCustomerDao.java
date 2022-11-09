package com.acmefresh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acmefresh.model.InfrastructureForCustomer;


@Repository
public interface InfrastructureForCustomerDao extends JpaRepository<InfrastructureForCustomer, Integer>{

}
