package com.acmefresh.service.SerivceInterface;

import com.acmefresh.DTO.LoginDTO;
import com.acmefresh.exceptions.LoginException;
import com.acmefresh.model.AcmeFreshHydroponicProduce;
import com.acmefresh.model.Admin;

public interface AdminService {

	public Admin registerAdmin(Admin admin);

	public Admin updatePassword(LoginDTO dto, String username, String key);

	public Admin updateAdmin(Admin admin, String Username, String key);
	
	public String addProducts(AcmeFreshHydroponicProduce produce, String key);
	
	public String updateProduct(AcmeFreshHydroponicProduce produce, String key);
	
	public String updatePriceOfProductById(Integer id, Double newPrice, String key);
    
	public String deleteByUsername(LoginDTO dto, String key);

	public String logoutAdmin(String key) throws LoginException;
	
}
