package com.myshop.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myshop.model.Product;
import com.myshop.repository.ProductGrpRepositoy;
import com.myshop.repository.ProductsRepository;

@Controller
public class DetailProductController {
	@Autowired
	ProductsRepository productsRepository;
	@Autowired
	ProductGrpRepositoy productsgrpRepository;

	@RequestMapping(value = "/detailproduct", method = RequestMethod.GET)
	public String getDetailProduct(Model model) {
		model.addAttribute("productgrp", productsgrpRepository.findAll());
		return "detailprod-guest";
	}
	
	@RequestMapping(value = "/detailproduct/{id}", method = RequestMethod.GET)
	public String findByProductId(@PathVariable("id") int id,Model model) {
		Product result = productsRepository.findByProdid(id);
		model.addAttribute("name",result.getProdname());
		System.out.println("name"+result.getProdname());
		return "redirect:/detailproduct";
	}
}
