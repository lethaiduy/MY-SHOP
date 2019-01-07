package com.dxc.controller;

import java.math.BigDecimal;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dxc.entity.Account;
import com.dxc.entity.DetailOrder;
import com.dxc.entity.Order;
import com.dxc.entity.Product;
import com.dxc.repository.AccountRepository;
import com.dxc.repository.DetailOrderRepository;
import com.dxc.repository.OrderRepository;

@Controller
@SessionAttributes(value={"prodselected","account"})

public class PaymentController {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private DetailOrderRepository detailOrderRepository;

	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String showPages(Model model, Product Product, HttpSession http) {
		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) http.getAttribute("prodselected");
		model.addAttribute("products", products);
		return "payment-user";
	}

	@RequestMapping(value = "/payment/save", method = RequestMethod.POST)
	public String save(@Valid Account account, Order invoice, @RequestParam(value = "total_money") BigDecimal sum,
			HttpSession http) {
		  int sumPoint= 0;
        Account acc= (Account)http.getAttribute("account");
		accountRepository.save(account);
		invoice.setAccount(account);
		invoice.setDate_order(new Date());
		invoice.setTotal_price(sum);
		orderRepository.save(invoice);
		List<Product> products = (List<Product>) http.getAttribute("prodselected");
		for (Product product : products) {
			DetailOrder detail= new DetailOrder();
			detail.setOrder(invoice);
			detail.setProduct(product);
			detail.setQuantity(1);
			sumPoint=sumPoint+product.getPoint();
			detailOrderRepository.save(detail);
		}
		System.out.println(sumPoint);
		acc.setPoint(sumPoint);
		accountRepository.updatePoint(acc.getAccountid(), acc.getPoint());
		return "redirect:/notify";
	}

}
