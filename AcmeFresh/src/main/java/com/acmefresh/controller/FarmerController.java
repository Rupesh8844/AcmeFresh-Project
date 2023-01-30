package com.acmefresh.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acmefresh.DTO.LoginDTO;
import com.acmefresh.model.AcmeFreshHydroponicProduce;
import com.acmefresh.model.Farmer;
import com.acmefresh.model.FarmerSession;
import com.acmefresh.service.serviceImpl.FarmerServiceImpl;
import com.acmefresh.service.serviceImpl.LoginServiceImpl;

@RestController
@RequestMapping("/homepage/store/client")
public class FarmerController {

	
	@Autowired
	private LoginServiceImpl loginService;
	
	@Autowired
	private FarmerServiceImpl farmerService;
	
	@PostMapping("/login")
	public ResponseEntity<FarmerSession> loginFarmerHandler(@RequestBody LoginDTO dto) {
		return new ResponseEntity<>(loginService.loginClient(dto), HttpStatus.ACCEPTED);
	}

	@PostMapping("/register")
	public ResponseEntity<Farmer> registerFarmerHandler(@RequestBody Farmer newuser) {
		return new ResponseEntity<>(farmerService.registerFarmer(newuser), HttpStatus.CREATED);

	}


	@PutMapping("/update/{username}")
	public ResponseEntity<Farmer> updateFarmerHandler(@RequestBody Farmer update, @PathVariable("username") String username,
			@RequestParam String key) {
		return new ResponseEntity<>(farmerService.updateFarmer(update, username, key), HttpStatus.ACCEPTED);
	}

	
	
	@PostMapping("/addnewproduct")
	public ResponseEntity<String> addNewProductHandler(@Valid @RequestBody AcmeFreshHydroponicProduce produce, String key) {
		return new ResponseEntity<>(farmerService.addProducts(produce, key), HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/updatepriceofproduct/{id}")
	public ResponseEntity<String> updatePriceByProductIdHandler(@RequestParam Double price , @PathVariable("id") Integer id,
			@RequestParam String key) {
		return new ResponseEntity<>(farmerService.updatePriceOfProductById(id, price, key), HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/updateproduct")
	public ResponseEntity<String> updateProductHandler(@Valid @RequestBody AcmeFreshHydroponicProduce produce, @RequestParam String key) {
		return new ResponseEntity<>(farmerService.updateProduct(produce, key), HttpStatus.ACCEPTED);
	}
	
	
	
	@DeleteMapping("/deleteaccount")
	public ResponseEntity<String> deleteFarmerHandler(@RequestBody LoginDTO dto, @RequestParam String key) {
		return new ResponseEntity<>(farmerService.deleteByUsername(dto, key), HttpStatus.ACCEPTED);

	}
	
}
