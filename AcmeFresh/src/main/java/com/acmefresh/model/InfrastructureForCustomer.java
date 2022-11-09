package com.acmefresh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class InfrastructureForCustomer {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull(message="Please enter the username")
	@Pattern(regexp = "^[a-zA-Z0-9]{3,20}", message = "length must be greater or equals to 3 and less than 20")
	private String username;
	
	@NotNull(message = "Please enter the emaild id")
	@Column(unique = true)
	@Email
	private String email;
	
	
	@NotNull(message = "Please enter the mobile Number")
	@Column(unique = true)
	@Pattern(regexp = "[6-9]{1}[0-9]{9}", message = "Enter valid 10 digit mobile number")
	private String mobile;
	
	
    private ListOfHydrophonicInfrastructure methods;
	
}


