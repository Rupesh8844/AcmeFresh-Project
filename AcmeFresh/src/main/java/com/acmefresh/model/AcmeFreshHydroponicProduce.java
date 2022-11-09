package com.acmefresh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class AcmeFreshHydroponicProduce {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer productId;
	
	@NotNull
	String productName;
	
	
	@NotNull
	String producerName;
	
	@NotNull
	Integer quantity_in_kgs;
	
	@NotNull
	Double Price;
	
}
