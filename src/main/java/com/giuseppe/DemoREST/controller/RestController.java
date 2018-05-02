package com.giuseppe.DemoREST.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.giuseppe.DemoREST.model.Customer;
import com.giuseppe.DemoREST.service.RestService;

@Controller(value = "controller")
@RequestMapping(path = "/customer")
public class RestController {

	private final Logger log = LogManager.getLogger(RestController.class);

	@Autowired
	private RestService restService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getCustomerListJson() {
		log.info("Inside RestController - getCustomerListJson");

		return new ResponseEntity<List<Customer>>(restService.getCustomerList(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, params = "id")
	public ResponseEntity<Customer> getSingleCustomerJson(@RequestParam("id") long id) {
		log.info("Inside RestController - getSingleCustomerJson");

		return new ResponseEntity<Customer>(restService.getSingleCustomer(id), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Customer saveCustomer(@RequestBody Customer customer) {
		log.info("Inside RestController - saveCustomer");

		return restService.saveCustomer(customer);
	}

	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public Customer modifyCustomer(@RequestBody Customer customer) {
		log.info("Inside RestController - modifyCustomer");
		
		return restService.modifyCustomer(customer);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteCustomer(@RequestParam("id") long id) {
		log.info("Inside RestController - deleteCustomer");
		
		restService.deleteCustomer(id);
	}
}
