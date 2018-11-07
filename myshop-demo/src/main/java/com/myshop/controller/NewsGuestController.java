package com.myshop.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class NewsGuestController {
	@RequestMapping(value = "/guest/hello")
	public String getNewsGuest()  {
		return "hello";
	}
}
