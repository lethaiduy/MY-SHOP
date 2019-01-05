package com.dxc.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dxc.entity.Account;
import com.dxc.entity.Order;
import com.dxc.entity.Product;
import com.dxc.repository.AccountRepository;
import com.dxc.repository.OrderRepository;

@Controller
@SessionAttributes("prodselected")
public class PaymentController {
	
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private OrderRepository orderRepository;
	
	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String showPages(Model model,Product Product,HttpSession http ){
		@SuppressWarnings("unchecked")
		List<Product> products=(List<Product>)http.getAttribute("prodselected");
		model.addAttribute("products", products);
		return "payment-user";
	}
	@RequestMapping(value = "/payment/save", method = RequestMethod.POST)
	public String save(@Valid Account account,@Valid Order order){
		accountRepository.save(account);
		order.setAccount(account);
		order.setDate_order(null);
		order.setTotal_price(null);
		orderRepository.save(order);
		return "login-guest";
	}
	
}
