package com.giuseppe.DemoREST.repository;

import org.springframework.data.repository.CrudRepository;

import com.giuseppe.DemoREST.model.Customer;

public interface RestRepository extends CrudRepository<Customer, Long>{
	
}
