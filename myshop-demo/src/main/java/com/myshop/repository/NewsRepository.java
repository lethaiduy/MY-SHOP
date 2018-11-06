package com.myshop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.myshop.model.News;

@RepositoryRestResource
public interface NewsRepository extends CrudRepository<News, Long>{
	List<News> findAll();
    News findByNewsid(int id);

}
