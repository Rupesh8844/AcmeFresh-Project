package com.acmefresh.service;

import org.springframework.stereotype.Service;

import com.acmefresh.model.InfrastructureForCustomer;
import com.acmefresh.repository.InfrastructureForCustomerDao;
import com.acmefresh.service.SerivceInterface.InfrastructureForCustomerService;


@Service
public class InfrastructureForCustomerServiceImpl implements InfrastructureForCustomerService{

	
	private InfrastructureForCustomerDao infasDao;
	
	@Override
	public InfrastructureForCustomer savingRequest(InfrastructureForCustomer request) {
		return infasDao.save(request);
	}

}
