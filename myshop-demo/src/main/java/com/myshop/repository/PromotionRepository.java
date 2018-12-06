package com.myshop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.myshop.model.Promotion;

@RepositoryRestResource
public interface PromotionRepository extends CrudRepository<Promotion, Long> {
	List<Promotion> findAll();
}
