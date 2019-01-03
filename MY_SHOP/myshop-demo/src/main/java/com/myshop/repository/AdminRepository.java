package com.myshop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.myshop.model.Admin;
@RepositoryRestResource
public interface AdminRepository extends CrudRepository<Admin, Long> {
 List<Admin> findAll();
}
