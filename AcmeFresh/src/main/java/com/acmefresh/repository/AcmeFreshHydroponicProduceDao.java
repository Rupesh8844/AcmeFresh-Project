package com.acmefresh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.acmefresh.model.AcmeFreshHydroponicProduce;

@Repository
public interface AcmeFreshHydroponicProduceDao extends JpaRepository<AcmeFreshHydroponicProduce, Integer>{

}
