package com.myshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myshop.model.News;
import com.myshop.repository.NewsRepository;

@Controller
public class NewsController {
	@Autowired
	private NewsRepository newsRepository;
	@RequestMapping(value ="/news/list", method = RequestMethod.GET)
	public List<News> searchListNews() {
		List<News> list = newsRepository.findAll();
		return list;
	}
	
	@RequestMapping(value="/news",method=RequestMethod.GET)
    public String homeNews(){
    	return "news-manage";
    }
}
