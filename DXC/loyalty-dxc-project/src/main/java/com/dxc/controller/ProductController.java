package com.dxc.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dxc.entity.Account;
import com.dxc.entity.Product;
import com.dxc.repository.AccountRepository;
import com.dxc.repository.ProductRepository;


@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private AccountRepository accountRepository;
	public static List<Product> products= new ArrayList<>();

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String show(Model model, Product product,Account account,HttpSession http){
		model.addAttribute("product",productRepository.findAll());
		if (null!=http.getAttribute("account")){
			Account acc=(Account)http.getAttribute("account");
			
			Account newAccount = new Account();
			List<Account> listAccount= new ArrayList<>();
			listAccount=accountRepository.findAll();
			for (Account account2 : listAccount) {
				if (account2.getAccountid()==acc.getAccountid())
					model.addAttribute("accountlogin", account2);
			}
			System.out.println(acc.getPoint());
			System.out.println("Co acc");
		}
		return "home-guest";
	}
	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public String findByProductId(@PathVariable("id") int id, Model model,HttpSession http) {
		Product result = productRepository.findByProdid(id);
		model.addAttribute("product", result);
		products.add(result);
		http.setAttribute("prodselected", products);
		return "redirect:/payment";
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession http) {
		if (null!=http.getAttribute("account"))
		{
			http.removeAttribute("account");
			return "redirect:/login";
		}
		return "redirect:/product";	
	}
}
