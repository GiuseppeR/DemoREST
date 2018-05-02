package com.giuseppe.DemoREST.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giuseppe.DemoREST.model.Customer;
import com.giuseppe.DemoREST.repository.RestRepository;

@Service(value = "service")
public class RestServiceImpl implements RestService {

	Logger log = LogManager.getLogger(RestServiceImpl.class);

	@Autowired
	private RestRepository restRepository;

	@Override
	public List<Customer> getCustomerList() {
		
		return (List<Customer>) restRepository.findAll();
	}
	
	@Override
	public Customer getSingleCustomer(Long id) {
		return restRepository.findOne(id);
	}

	@Override
	public Customer saveCustomer(Customer customer) {

		log.info("Inside RestServiceImpl - saveCustomer");

		return restRepository.save(customer);
	}
	
	@Override
	public Customer modifyCustomer(Customer customer){
		
		log.info("Inside RestServiceImpl - modifyCustomer");
		
		return restRepository.save(customer);
	}

	@Override
	public void deleteCustomer(Long id) {
		
		log.info("Inside RestServiceImpl - deleteCustomer");

		restRepository.delete(id);
	}
}
