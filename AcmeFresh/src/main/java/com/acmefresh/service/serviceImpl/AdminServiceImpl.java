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
	
	

	

}
