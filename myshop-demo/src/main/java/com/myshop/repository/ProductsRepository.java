package com.myshop.repository;

import java.util.List;



import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.model.Product;

@RepositoryRestResource
@Transactional
public interface ProductsRepository  extends CrudRepository<Product,Long>{
  List<Product> findAll();
}
