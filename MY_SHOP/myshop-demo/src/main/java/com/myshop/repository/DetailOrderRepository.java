package com.myshop.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.model.DetailOrder;

@RepositoryRestResource
public interface DetailOrderRepository extends CrudRepository<DetailOrder, Long> {
	/* @Modifying(clearAutomatically = true)
	    @Transactional
	    @Query("update DetailOrder detail  set detail.title =:isTitle,news.dateSub=:isDateSub,news.detail=:isDetail,news.image=:isImage where news.newsid =:newsId")
	   public  void findById(@Param("newsId") int newsId, @Param("isDateSub") Date isDateSub , @Param("isTitle") String isTitle, @Param("isDetail") String isDetail, @Param("isImage") byte[] isImage);*/
}
