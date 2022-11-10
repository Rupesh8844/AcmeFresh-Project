package com.acmefresh.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FarmerSession {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	private Integer clientId;
	
	private String uuid;
	
	private LocalDateTime localDateTime;
	
	
	public FarmerSession(Integer customerId, String uuid, LocalDateTime localDateTime) {
		super();
		this.clientId = customerId;
		this.uuid = uuid;
		this.localDateTime = localDateTime;
	}
	
	
}
