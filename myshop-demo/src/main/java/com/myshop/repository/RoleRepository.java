package com.myshop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.myshop.model.Role;

public interface RoleRepository  extends CrudRepository<Role, Long>{
  List<Role> findAll();
}
