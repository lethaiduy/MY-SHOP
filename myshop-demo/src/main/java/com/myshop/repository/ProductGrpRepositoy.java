package com.myshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.model.ProductGrp;

@RepositoryRestResource
@Transactional
public interface ProductGrpRepositoy extends CrudRepository<ProductGrp, Long> {

}
