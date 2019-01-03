package com.dxc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dxc.entity.Product;
import com.dxc.repository.ProductRepository;


@Controller
public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	@RequestMapping(name = "/product", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getListAccount(Product product) {

		List<Product> list = productRepository.findAll();
		if (list.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	


	
	
}
