package com.myshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.myshop.model.Order;
import com.myshop.model.Product;
import com.myshop.repository.NewsRepository;
import com.myshop.repository.PaymentMethodRepository;

@Controller
@SessionAttributes("prodlist1")
public class PaymentController {
	@Autowired
	PaymentMethodRepository paymentMethodRepository;
	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String getPayment(Model model, HttpSession http) {
		/* model.addAttribute("orders", orderRepository.findAll()); */
		if (http.getAttribute("prodlist1") != null) {
			
			Product products = (Product) (http.getAttribute("prodlist1"));
			model.addAttribute("prdPayment", products);
			
		}
		else System.out.println("null");
		model.addAttribute("paymentmethod", paymentMethodRepository.findAll());
		return "payment-user";
	}

}
