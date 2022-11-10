package com.acmefresh.service.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmefresh.DTO.LoginDTO;
import com.acmefresh.exceptions.LoginException;
import com.acmefresh.exceptions.UsernameNotFoundException;
import com.acmefresh.model.AcmeFreshHydroponicProduce;
import com.acmefresh.model.Farmer;
import com.acmefresh.model.FarmerSession;
import com.acmefresh.repository.AcmeFreshHydroponicProduceDao;
import com.acmefresh.repository.FarmerDao;
import com.acmefresh.repository.FarmerSessionDao;
import com.acmefresh.service.SerivceInterface.FarmerService;

@Service
public class FarmerServiceImpl implements FarmerService{

	@Autowired
	private FarmerDao clientDao;
	
	@Autowired
	private FarmerSessionDao sessionDao;
	
	@Autowired
	private AcmeFreshHydroponicProduceDao productDao;

	
	
	@Override
	public Farmer registerClient(Farmer newuser) {
		return clientDao.save(newuser);
	}
	
	

	@Override
	public Farmer updateClient(Farmer update, String Username, String key) {
		Farmer updatedClient = null;
		Optional<FarmerSession> otp = sessionDao.findByUuid(key);

		if (otp.isEmpty()) {
			throw new LoginException("User is not logged in, Please login first!");
		}
		else {
			Optional<Farmer> opt = clientDao.findByUsername(Username);
			if (opt.isEmpty()) {
				throw new UsernameNotFoundException("Username not found. Please provide proper username");
			}
			else {
				updatedClient = clientDao.save(update);
			}
		}
		return updatedClient;
	}
	
	

	@Override
	public String addProducts(AcmeFreshHydroponicProduce produce, String key) {
		Optional<FarmerSession> otp = sessionDao.findByUuid(key);

		if (otp.isEmpty())
			throw new LoginException("User is not logged in, Please login first!");
		
		productDao.save(produce);
		
		return "Product has been added Successfully...";
	}

	
	
	@Override
	public String updateProduct(AcmeFreshHydroponicProduce produce, String key) {
		Optional<FarmerSession> otp = sessionDao.findByUuid(key);

		if (otp.isEmpty()) {
			throw new LoginException("User is not logged in, Please login first!");
		}
		
		Optional<AcmeFreshHydroponicProduce> opt=productDao.findById(produce.getProductId());
		
		if(opt.isEmpty()) {
			throw new LoginException("Product not found with this Id..");
		}
		
		productDao.save(produce);
		return "Product have been updated Successfully...";
	}

	
	
	@Override
	public String updatePriceOfProductById(Integer id, Double newPrice, String key) {
		Optional<FarmerSession> otp = sessionDao.findByUuid(key);

		if (otp.isEmpty()) {
			throw new LoginException("User is not logged in, Please login first!");
		}
		
		Optional<AcmeFreshHydroponicProduce> opt=productDao.findById(id);
		
		if(opt.isEmpty()) {
			throw new LoginException("Product not found with this Id..");
		}
		
		AcmeFreshHydroponicProduce old =opt.get();
		old.setPrice(newPrice);
		productDao.save(old);
		return "Price have been updated..";
	}

	
	
	@Override
	public String deleteByUsername(LoginDTO dto, String key) {
		
		Optional<FarmerSession> otp = sessionDao.findByUuid(key);
		
		if (otp.isEmpty()) {
			throw new LoginException("User is not logged in, Please login first!");
		}
		else {
			Optional<Farmer> opt = clientDao.findByUsername(dto.getUsername());
			if (opt.isEmpty()) {
				throw new UsernameNotFoundException("Username not found");
			}
			else {
				Farmer client = opt.get();
				clientDao.delete(client);
			}
		}
		return "Id with Username " + dto.getUsername() + " is Deleted.";
	}
	
	

	@Override
	public String logoutClient(String key) {
		
		Optional<FarmerSession> otp = sessionDao.findByUuid(key);
		
		if (otp.isEmpty()) {
			throw new LoginException("User is not logged in, Please login first!");
		}

	    sessionDao.delete(otp.get());
		return "You have been succefully logged out.";
	}

	
}
