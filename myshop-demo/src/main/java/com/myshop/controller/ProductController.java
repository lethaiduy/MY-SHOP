package com.myshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myshop.repository.ProductsRepository;

@Controller
public class ProductController {
	@Autowired
	ProductsRepository productsRepository;
	@RequestMapping(value = "/product",method=RequestMethod.GET)
	public String getProduct(Model model)  {
		model.addAttribute("product", productsRepository.findAll());
		return "product-manager";
	}

}
