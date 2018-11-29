package com.myshop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.myshop.model.Customer;

@RepositoryRestResource
public interface CustomerRepository extends CrudRepository<Customer,Long>{
	List<Customer> findAll();
	Customer findByCustomerid(int id);
	
}
