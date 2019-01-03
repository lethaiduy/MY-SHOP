package com.myshop.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.myshop.model.PaymentMethod;

public interface PaymentMethodRepository extends CrudRepository<PaymentMethod, Long> {
  List<PaymentMethod> findAll();
}
