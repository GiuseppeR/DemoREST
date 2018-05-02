package com.giuseppe.DemoREST.service;

import java.util.List;
import com.giuseppe.DemoREST.model.Customer;

public interface RestService {

	public List<Customer> getCustomerList();

	public Customer getSingleCustomer(Long id);

	public Customer saveCustomer(Customer customer);

	public Customer modifyCustomer(Customer customer);

	public void deleteCustomer(Long id);
}
