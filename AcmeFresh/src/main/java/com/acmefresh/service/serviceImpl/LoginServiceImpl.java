package com.acmefresh.service.serviceImpl;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmefresh.DTO.LoginDTO;
import com.acmefresh.exceptions.CustomerException;
import com.acmefresh.exceptions.LoginException;
import com.acmefresh.model.Admin;
import com.acmefresh.model.AdminSession;
import com.acmefresh.model.Client;
import com.acmefresh.model.ClientSession;
import com.acmefresh.model.Customer;
import com.acmefresh.model.CustomerSession;
import com.acmefresh.repository.AdminDao;
import com.acmefresh.repository.AdminSessionDao;
import com.acmefresh.repository.ClientDao;
import com.acmefresh.repository.ClientSessionDao;
import com.acmefresh.repository.CustomerDao;
import com.acmefresh.repository.CustomerSessionDao;
import com.acmefresh.service.SerivceInterface.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private CustomerDao customerDAO;

	@Autowired
	private CustomerSessionDao customerSessionDAO;
	
	@Autowired
	private ClientDao clientDao;
	
	@Autowired
	private ClientSessionDao clientSessionDao;
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private AdminSessionDao adminSessionDao;

	@Override
	public AdminSession loginAdmin(LoginDTO admin) {
		
		Optional<Admin> res =  adminDao.findByMobile(admin.getMobile());

		if (res.isEmpty()) {
			System.out.println("No Admin exist");
			throw new CustomerException("Admin was not there in the data base");
		}

		Admin existingAdmin = res.get();
		
		Optional<AdminSession> opt = adminSessionDao.findByAdminId(existingAdmin.getAdminId());

		if (opt.isPresent()) {
			throw new LoginException("User already logged in");
		}

		if (existingAdmin.getPassword().equals(admin.getPassword())) {

			AdminSession newSession = new AdminSession();
			newSession.setAdminId(existingAdmin.getAdminId());
			newSession.setLocalDateTime(LocalDateTime.now());
			
			UUID uuid = UUID.randomUUID();
			String token = uuid.toString().split("-")[0];

			newSession.setUuid(token);

			return adminSessionDao.save(newSession);
			
		} else {
			throw new LoginException("Password Incorrect. Try again...");
		}
	}
	

	@Override
	public ClientSession loginClient(LoginDTO client) {
		
		Optional<Client> res = clientDao.findByMobile(client.getMobile());

		if (!res.isPresent()) {
			System.out.println(res + " Data is empty");
			throw new CustomerException("Client does not exist with the given mobile number");
		}

		Client existingClient = res.get();
		Optional<ClientSession> opt = clientSessionDao.findByClientId(existingClient.getClientId());

		if (opt.isPresent())
			throw new LoginException("User already logged in");

		if (existingClient.getPassword().equals(client.getPassword())) {

			ClientSession newSession = new ClientSession();

			newSession.setClientId(existingClient.getClientId());
			newSession.setLocalDateTime(LocalDateTime.now());

			UUID uuid = UUID.randomUUID();
			String token = uuid.toString().split("-")[0];

			newSession.setUuid(token);

			return clientSessionDao.save(newSession);
			
		} else {
			throw new LoginException("Password Incorrect. Try again...");
		}

	}

	@Override
	public CustomerSession loginCustomer(LoginDTO customer) {

		Optional<Customer> res = customerDAO.findByMobile(customer.getMobile());

		if (!res.isPresent()) {
			System.out.println(res + " Data is empty");
			throw new CustomerException("Customer does not exist with the given mobile number");
		}

		Customer existingCustomer = res.get();
		Optional<CustomerSession> opt = customerSessionDAO.findByCustomerId(existingCustomer.getCustomerId());

		if (opt.isPresent())
			throw new LoginException("User already logged in");

		if (existingCustomer.getPassword().equals(customer.getPassword())) {

			CustomerSession newSession = new CustomerSession();

			newSession.setCustomerId(existingCustomer.getCustomerId());
			newSession.setLocalDateTime(LocalDateTime.now());

			UUID uuid = UUID.randomUUID();
			String token = uuid.toString().split("-")[0];

			newSession.setUuid(token);

			return customerSessionDAO.save(newSession);
		} else {
			throw new LoginException("Password Incorrect. Try again.");
		}

	}
	
}
