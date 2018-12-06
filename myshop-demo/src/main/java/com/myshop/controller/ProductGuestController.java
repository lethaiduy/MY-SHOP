package com.myshop.controller;

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
public class ProductGuestController {
	@Autowired
	ProductsRepository productsRepository;
	@Autowired
	ProductGrpRepositoy productgrpRepository;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getProduct(Model model) {
		model.addAttribute("products", productsRepository.findAll());
		model.addAttribute("productgrps", productgrpRepository.findAll());
		return "home-guest";
	}
	
}
