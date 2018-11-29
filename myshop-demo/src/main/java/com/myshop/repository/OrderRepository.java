package com.myshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.model.Order;

@RepositoryRestResource
public interface OrderRepository extends CrudRepository<Order, Long> {
	List<Order> findAll();

	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update Order od set od.status =:isStatus where od.orderid =:isOrderid")
	public void updateOrder(@Param("isStatus") String isStatus, @Param("isOrderid") int isOrderid );
}
