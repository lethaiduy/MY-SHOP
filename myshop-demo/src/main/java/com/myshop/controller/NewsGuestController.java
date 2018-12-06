package com.myshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myshop.repository.NewsRepository;

@Controller
public class NewsGuestController {
	@Autowired
	NewsRepository newsRepository;

	@RequestMapping(value = "/user-news",method=RequestMethod.GET)
	public String getNewsGuest(Model model ) {
		model.addAttribute("newsuser",newsRepository.findAll());
		return "news-guest";
	}
}
