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
public class CustomerSession {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	
	private Integer customerId;
	
	private String uuid;
	
	private LocalDateTime localDateTime;
	
	
	public CustomerSession(Integer customerId, String uuid, LocalDateTime localDateTime) {
		super();
		this.customerId = customerId;
		this.uuid = uuid;
		this.localDateTime = localDateTime;
	}
	
}
