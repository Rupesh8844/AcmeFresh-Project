package com.acmefresh.service.SerivceInterface;

import com.acmefresh.DTO.LoginDTO;
import com.acmefresh.model.AcmeFreshHydroponicProduce;
import com.acmefresh.model.Client;

public interface ClientService {

	public Client registerClient(Client newuser);
	
	public Client  updateClient(Client  update, String Username, String key);

	public String addProducts(AcmeFreshHydroponicProduce produce, String key);
	
	public String updateProduct(AcmeFreshHydroponicProduce produce, String key);
	
	public String updatePriceOfProductById(Integer id, Double newPrice, String key);

	public String deleteByUsername(LoginDTO  dto, String key);

	public String logoutClient(String key);
	
}
