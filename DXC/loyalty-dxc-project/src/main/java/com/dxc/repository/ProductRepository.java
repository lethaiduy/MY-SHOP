package com.dxc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.dxc.entity.Product;

@RepositoryRestResource
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();
	Product findByProdid(int id);
}
