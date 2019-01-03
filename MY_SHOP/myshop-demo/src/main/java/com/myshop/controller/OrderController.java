package com.myshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.myshop.model.News;
import com.myshop.model.Order;
import com.myshop.model.Product;
import com.myshop.repository.OrderRepository;

@Controller
@SessionAttributes("prodlist2")
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;
	
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String getOrder(Model model, Order order,HttpSession http)  {
		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) (http.getAttribute("prodlist2"));
		model.addAttribute("orders",orderRepository.findAll());
		model.addAttribute("products", products);
		return "order-manage";
	}

	@RequestMapping(value = "/order/update", method = RequestMethod.POST)
	public String update(Order order) {

		orderRepository.updateOrder(order.getStatus(),order.getOrderid());
		return "redirect:/order";

	}

}
