package com.acmefresh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acmefresh.DTO.LoginDTO;
import com.acmefresh.model.AcmeFreshHydroponicProduce;
import com.acmefresh.model.Customer;
import com.acmefresh.model.CustomerSession;
import com.acmefresh.service.serviceImpl.CustomerServiceImpl;
import com.acmefresh.service.serviceImpl.LoginServiceImpl;

@RestController
@RequestMapping("/homepage/store/customer")
public class CustomerController {

	
	@Autowired
	private LoginServiceImpl loginService;
	
	@Autowired
	private CustomerServiceImpl customersService;
	
	
	
	
	@PostMapping("/login")
	public ResponseEntity<CustomerSession> loginCustomerHandler(@RequestBody LoginDTO dto) {
		return new ResponseEntity<>(loginService.loginCustomer(dto), HttpStatus.ACCEPTED);
	}

	@PostMapping("/register")
	public ResponseEntity<Customer> registerCustomerHandler(@RequestBody Customer newuser) {
		return new ResponseEntity<>(customersService.registerCustomer(newuser), HttpStatus.CREATED);

	}


	@PutMapping("/update/{username}")
	public ResponseEntity<Customer> updateCustomerHandler(@RequestBody Customer update, @PathVariable("username") String username,
			@RequestParam String key) {
		return new ResponseEntity<>(customersService.updateCustomer(update, username, key), HttpStatus.ACCEPTED);
	}

	
	@GetMapping("/products")
	public ResponseEntity<List<AcmeFreshHydroponicProduce>> getAllProductsHandler(@RequestParam String key) {

		return new ResponseEntity<>(customersService.getAllProduct(key), HttpStatus.ACCEPTED);

	}
	
	
	
	@DeleteMapping("/deleteaccount")
	public ResponseEntity<String> deleteCustomerHanlder(@RequestBody LoginDTO dto, @RequestParam String key) {
		return new ResponseEntity<>(customersService.deleteByUsername(dto, key), HttpStatus.ACCEPTED);

	}

	@GetMapping("/logout")
	public ResponseEntity<String> logoutCustomerHandler(@RequestParam String key) {

		return new ResponseEntity<>(customersService.logoutCustomer(key), HttpStatus.ACCEPTED);

	}
	
}
