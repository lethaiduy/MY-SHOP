package com.myshop.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myshop.model.Admin;
import com.myshop.repository.AdminRepository;

@Controller
public class LoginController {
	@Autowired
	AdminRepository adminRepository;
	
	@RequestMapping(value = "/login-admin", method = RequestMethod.GET)
	public String showwPage() {
		return "login-guest";
	}
	@RequestMapping(value = "/login-admin/login", method = RequestMethod.GET)
	public String getLogin(Model model,@RequestParam(value="username",required=false) String username,@RequestParam(value="password",required=false) String password) {
		List<Admin> listAdmin= adminRepository.findAll();
		for (Admin admin : listAdmin) {
			if (username.equals(admin.getUsername()) && password.equals(admin.getPassword()))
				return "redirect:/home-admin";
			else return "redirect:/login-admin";
				
		}
		return "login-guest";
	}
}
