package com.dxc.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.dxc.entity.DetailOrder;

@RepositoryRestResource
public interface DetailOrderRepository extends CrudRepository<DetailOrder, Long> {
  List<DetailOrder> findAll();
}
