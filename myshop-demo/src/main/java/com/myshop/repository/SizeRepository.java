package com.myshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.model.Size;

@RepositoryRestResource
@Transactional
public interface SizeRepository extends CrudRepository<Size,Long> {
  List<Size> findAll();
  Size findByProductesProdid(int id);


}
