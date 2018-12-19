package com.myshop.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myshop.model.Customer;
import com.myshop.model.DetailOrder;
import com.myshop.model.Order;
import com.myshop.model.PaymentMethod;
import com.myshop.model.Product;
import com.myshop.model.Promotion;
import com.myshop.repository.ProductsRepository;
import com.myshop.repository.PromotionRepository;

@Controller
public class PromotionController {
	@Autowired
	private PromotionRepository promotionRepository;
    @Autowired
    private ProductsRepository productsRepository;

	@RequestMapping(value = "/promotion", method = RequestMethod.GET)
	public String getNews(Model model, Promotion promotion) {
		model.addAttribute("promotions", promotionRepository.findAll());
	/*	model.addAttribute("product", productsRepository.findAll());*/
		return "promotion-manage";
	}
	@RequestMapping(value = "/promotion/save", method = RequestMethod.POST)
	public String save( @Valid Promotion promotion) throws Exception {
		promotionRepository.save(promotion);
		return "redirect:/promotion";
	}
	

}
