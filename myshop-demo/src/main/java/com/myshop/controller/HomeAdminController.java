package com.myshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeAdminController {
	@RequestMapping(value = "/home-admin", method = RequestMethod.GET)
	public String showwPageHome() {
		return "home-administrator";
	}
}
