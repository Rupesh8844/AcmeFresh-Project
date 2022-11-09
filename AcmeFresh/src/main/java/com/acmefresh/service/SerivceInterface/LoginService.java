package com.acmefresh.service.SerivceInterface;

import com.acmefresh.DTO.LoginDTO;
import com.acmefresh.model.AdminSession;
import com.acmefresh.model.ClientSession;
import com.acmefresh.model.CustomerSession;

public interface LoginService {

	
	public AdminSession loginAdmin(LoginDTO admin);

	public ClientSession loginClient(LoginDTO client);
	
	public CustomerSession loginCustomer(LoginDTO customer);
	
	
}
