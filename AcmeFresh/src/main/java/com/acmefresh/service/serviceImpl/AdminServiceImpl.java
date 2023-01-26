package com.acmefresh.service.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmefresh.DTO.LoginDTO;
import com.acmefresh.exceptions.LoginException;
import com.acmefresh.exceptions.UsernameNotFoundException;
import com.acmefresh.model.AcmeFreshHydroponicProduce;
import com.acmefresh.model.Admin;
import com.acmefresh.model.AdminSession;
import com.acmefresh.repository.AcmeFreshHydroponicProduceDao;
import com.acmefresh.repository.AdminDao;
import com.acmefresh.repository.AdminSessionDao;
import com.acmefresh.service.SerivceInterface.AdminService;



@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao adminDao;

	@Autowired
	private AdminSessionDao adminSessionDao;
	
	@Autowired
	private AcmeFreshHydroponicProduceDao productDao;

	@Override
	public Admin registerAdmin(Admin admin) {
		return adminDao.save(admin);
	}

	@Override
	public Admin updatePassword(LoginDTO dto, String username, String key) {
		
		Optional<AdminSession> otp = adminSessionDao.findByUuid(key);
		
		Admin updatedAdmin = null;
		
		if (otp.isEmpty()) {
			throw new LoginException("Admin is not logged in, Please login first!");
		}
		
		Optional<Admin> opt = adminDao.findByUsername(username);
		
		if (opt.isEmpty()) {
			throw new UsernameNotFoundException("Username not found");
		}
		else {
			Admin toUpdate = opt.get();
			toUpdate.setPassword(dto.getPassword());
			updatedAdmin = adminDao.save(toUpdate);
		}
		
		return updatedAdmin;
	}
	
	

	
	@Override
	public Admin updateAdmin(Admin admin, String Username, String key) {
		
		Optional<AdminSession> otp = adminSessionDao.findByUuid(key);

		Admin updatedAdmin = null;
		
		if (otp.isEmpty()) {
			throw new LoginException("Admin is not logged in, Please login first!");
		}
		else {
			Optional<Admin> opt = adminDao.findByUsername(Username);
			if (opt.isEmpty()) {
				throw new UsernameNotFoundException("Username not found.");
			}
			else {
				Admin toUpdate = opt.get();
				updatedAdmin = adminDao.save(toUpdate);
			}
		}
		return updatedAdmin;
	}
	
	

	
	
	@Override
	public String addProducts(AcmeFreshHydroponicProduce produce, String key) {
		
		Optional<AdminSession> otp = adminSessionDao.findByUuid(key);
		
		if (otp.isEmpty()) {
			throw new LoginException("Admin is not logged in, Please login first!");
		}
		productDao.save(produce);
		return "Product has been added Successfully...";
	}

	
	
	@Override
	public String updateProduct(AcmeFreshHydroponicProduce produce, String key) {
		
		Optional<AdminSession> otp = adminSessionDao.findByUuid(key);
		
		if (otp.isEmpty()) {
			throw new LoginException("Admin is not logged in, Please login first!");
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
		
		Optional<AdminSession> otp = adminSessionDao.findByUuid(key);
		
		if (otp.isEmpty()) {
			throw new LoginException("Admin is not logged in, Please login first!");
		}
		
		Optional<AcmeFreshHydroponicProduce> opt=productDao.findById(id);
		
		if(opt.isEmpty()) {
			throw new LoginException("Product not found with this Id..");
		}
		
		AcmeFreshHydroponicProduce old =opt.get();
		old.setPrice(newPrice);
		productDao.save(old);
		return "Price have been updated Successfully...";
		
	}
	
	

}

