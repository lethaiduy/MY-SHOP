package com.dxc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NotificateController {
	
	@RequestMapping(value = "/notify", method = RequestMethod.GET)
	public String showNotification() {
		return "notification";
	}
}
