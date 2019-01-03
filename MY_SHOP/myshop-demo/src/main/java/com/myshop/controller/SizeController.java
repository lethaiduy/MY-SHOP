package com.myshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.myshop.repository.SizeRepository;

@Controller
public class SizeController {
	@Autowired
   SizeRepository sizeRepository;
	public void getProduct(Model model)  {
		model.addAttribute("product", sizeRepository.findAll());
	}
}
