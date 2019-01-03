package com.myshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.model.Customer;

@RepositoryRestResource
public interface CustomerRepository extends CrudRepository<Customer,Long>{
	List<Customer> findAll();
	Customer findByCustomerid(int id);
	@Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Customer customer set customer.fullname =:isFullName,customer.address=:isAddress,customer.cellphone=:isCellPhone,customer.email=:isEmail where customer.customerid =:isCustomerId")
   public  void updateCustomer(@Param("isCustomerId") int isCustomerId, @Param("isFullName") String isFullName , @Param("isAddress") String isAddress, @Param("isCellPhone") String isCellPhone, @Param("isEmail") String isEmail);
}
