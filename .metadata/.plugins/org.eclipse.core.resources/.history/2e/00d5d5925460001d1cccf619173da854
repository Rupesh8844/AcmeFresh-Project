package com.acmefresh.model;

import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CurrentCustomerSession {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	private Integer customerId;
	
	private String uuid;
	
	private LocalDateTime localDateTime;
	
	
	public CurrentCustomerSession(Integer customerId, String uuid, LocalDateTime localDateTime) {
		super();
		this.customerId = customerId;
		this.uuid = uuid;
		this.localDateTime = localDateTime;
	}
	
}
