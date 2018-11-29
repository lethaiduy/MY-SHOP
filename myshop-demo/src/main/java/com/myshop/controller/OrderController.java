package com.myshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myshop.model.News;
import com.myshop.model.Order;
import com.myshop.repository.OrderRepository;

@Controller
public class OrderController {
	@Autowired
	private OrderRepository orderRepository;
	
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String getOrder(Model model, Order order)  {
		model.addAttribute("orders",orderRepository.findAll());
		return "order-manage";
	}

	@RequestMapping(value = "/order/update", method = RequestMethod.POST)
	public String update(Order order) {

		orderRepository.updateOrder(order.getStatus(),order.getOrderid());
		return "redirect:/order";

	}

}
