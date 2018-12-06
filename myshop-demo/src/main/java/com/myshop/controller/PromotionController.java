package com.myshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myshop.model.Promotion;
import com.myshop.repository.PromotionRepository;

@Controller
public class PromotionController {
	@Autowired
	private PromotionRepository promotionRepository;

	@RequestMapping(value = "/promotion", method = RequestMethod.GET)
	public String getNews(Model model, Promotion promotion) {
		model.addAttribute("promotions", promotionRepository.findAll());
		for(int i=0;i<promotion.getPrd().size();i++)
		{
			System.out.println("id la:" +promotion.getPrd().get(i).getProdid());
		}
		return "promotion-manage";
	}

}
