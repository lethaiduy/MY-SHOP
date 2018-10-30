package com.myshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myshop.model.News;
import com.myshop.repository.NewsRepository;

@RestController
public class NewsController {
	@Autowired
	private NewsRepository newsRepository;
	@RequestMapping(value ="/news/list", method = RequestMethod.GET)
	public ResponseEntity<List<News>> searchListNews() {
		List<News> list = newsRepository.findAll();
		if (list.isEmpty()) {
			return new ResponseEntity<List<News>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<News>>(list, HttpStatus.OK);
	}

}
