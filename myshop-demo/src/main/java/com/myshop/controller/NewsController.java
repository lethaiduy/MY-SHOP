package com.myshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myshop.model.News;
import com.myshop.repository.NewsRepository;

@Controller
public class NewsController {
	@Autowired
	private NewsRepository newsRepository;

	@RequestMapping(value = "/newslist/", method = RequestMethod.GET)
	public ResponseEntity<List<News>> searchListCompany() {
		List<News> list = newsRepository.findAll();
		if (list.isEmpty()) {
			return new ResponseEntity<List<News>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<News>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public String getNews(Model model) {
		model.addAttribute("news", newsRepository.findAll());
		return "news-manage";
	}

	@RequestMapping(value = "/news/save", method = RequestMethod.POST)
	public String save(@RequestParam MultipartFile[] images, News news) throws Exception {
		if (images != null && images.length > 0) {
			for (MultipartFile aFile : images) {
				news.setImage(aFile.getBytes());
			}
		}
		newsRepository.save(news);
		return "redirect:/news";
	}

	@RequestMapping(value = "/news/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		News result = newsRepository.findByNewsid(id);
		if (result == null) {
			return "The id not exist";
		}
		newsRepository.delete(result);
		return "redirect:/news";
	}

	@RequestMapping(value = "/news/update/{id}", method = RequestMethod.GET)
	public void update(@PathVariable("id") int id, Model model) {
		News result = newsRepository.findByNewsid(id);
		model.addAttribute("newsupdate", result);
	}
	

}
