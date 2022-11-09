package com.acmefresh.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO {

	private String username;
	
	private String password;
	
	private String address;

	private String mobile;

	private String email;
	
	
}
