package com.myshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import com.myshop.model.Product;

@RepositoryRestResource
@Transactional
public interface ProductsRepository  extends CrudRepository<Product,Long>{
  List<Product> findAll();
  Product findByProdid(int id);
/*  Product findBySizes();*/
  
  @Modifying(clearAutomatically = true)
  @Transactional
  @Query("update Product product set product.prodname =:isProdName,product.image=:isImage,product.brand=:isBrand,product.fabric=:isFabric,product.price=:isPrice,product.quantity=:isQuantity,product.productGrp.prodgrpid=:isProdgrp,product.promotion.promid=:isProm where product.prodid =:isProdID")
 public  void updateProduct(@Param("isProdID") int isProdID, @Param("isProdName") String isProdName , @Param("isBrand") String isBrand, @Param("isFabric") String isFabric,@Param("isPrice") long isPrice, @Param("isQuantity") int isQuantity,@Param("isImage") byte[] isImage,@Param("isProdgrp") int isProdgrp,@Param("isProm") int isProm);
}
