package com.myshop.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.myshop.model.News;
import com.myshop.repository.NewsRepository;

@Controller
public class NewsController {
	@Autowired
	private NewsRepository newsRepository;

	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public String getNews(Model model, News news) {
		model.addAttribute("news", newsRepository.findAll());
		return "news-manage";
	}

	@RequestMapping(value = "/news/save", method = RequestMethod.POST)
	public String saveNews(News news,@Valid @RequestParam MultipartFile[] images) throws Exception {
		if (images != null && images.length > 0) {
			for (MultipartFile aFile : images) {
				news.setImage(aFile.getBytes());
			}
		}
		System.out.println(news.getTitle());
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

	@RequestMapping(value = "/news/update", method = RequestMethod.POST)
	public String update(News news) {

		newsRepository.updateNews(news.getNewsid(), news.getDateSub(), news.getTitle(), news.getDetail(),
				news.getImage());
		return "redirect:/news";

	}

}
