package com.acmefresh.service.SerivceInterface;

import java.util.List;

import com.acmefresh.DTO.LoginDTO;
import com.acmefresh.model.AcmeFreshHydroponicProduce;
import com.acmefresh.model.Customer;

public interface CustomerService {

	public Customer registerCustomer(Customer newuser);
	
	public Customer  updateCustomer(Customer  update, String Username, String key);
	
	public List<AcmeFreshHydroponicProduce> getAllProduct(String key);
	
	public String deleteByUsername(LoginDTO  dto, String key);

	public String logoutCustomer(String key);


}
