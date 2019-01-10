package com.dxc.controller;

import java.math.BigDecimal;
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

import com.dxc.entity.Account;
import com.dxc.entity.DetailOrder;
import com.dxc.entity.Order;
import com.dxc.entity.Point;
import com.dxc.entity.Product;
import com.dxc.repository.AccountRepository;
import com.dxc.repository.DetailOrderRepository;
import com.dxc.repository.OrderRepository;
import com.dxc.repository.PointRepository;

@Controller
public class PaymentController {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private DetailOrderRepository detailOrderRepository;
	@Autowired
	private PointRepository pointRepository;

	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String showPages(Model model, Product Product, HttpSession http) {
		List<Product> products = (List<Product>) http.getAttribute("prodselected");
		model.addAttribute("products", products);
		if (null!=http.getAttribute("account")){
			Account acc=(Account)http.getAttribute("account");
			model.addAttribute("accountselected", acc);
		}
		return "payment-user";
	}

	@RequestMapping(value = "/payment/save", method = RequestMethod.POST)
	public String save(@Valid Account accounts, @Valid Order invoice,
			@RequestParam(value = "total_money") BigDecimal sum, HttpSession http, Model model,Point point) {
		int sumPoint = 0;
		if (null!=http.getAttribute("account")){
			System.out.println("co acc");
			Account acc = (Account) http.getAttribute("account");
			invoice.setAccount(acc);
			invoice.setDate_order(new Date());
			invoice.setTotal_price(sum);
			orderRepository.save(invoice);
			
			@SuppressWarnings("unchecked")
			List<Product> products = (List<Product>) http.getAttribute("prodselected");
			for (Product product : products) {
				DetailOrder detail = new DetailOrder();
				detail.setOrder(invoice);
				detail.setProduct(product);
				detail.setQuantity(1);
				sumPoint = sumPoint + product.getPoint();
				detailOrderRepository.save(detail);
			}
			accountRepository.updatePoint(acc.getAccountid(), acc.getName(), acc.getAddress(), acc.getCellphone(),
					acc.getEmail(), acc.getPoint() + sumPoint);
			point.setPoint(sumPoint);
			point.setOrder(invoice);
			pointRepository.save(point);
		}
		else {
			System.out.println("khong có");
			accountRepository.save(accounts);
			invoice.setAccount(accounts);
			invoice.setDate_order(new Date());
			invoice.setTotal_price(sum);
			orderRepository.save(invoice);
			@SuppressWarnings("unchecked")
			List<Product> products = (List<Product>) http.getAttribute("prodselected");
			for (Product product : products) {
				DetailOrder detail = new DetailOrder();
				detail.setOrder(invoice);
				detail.setProduct(product);
				detail.setQuantity(1);
				detailOrderRepository.save(detail);
			}
			point.setPoint(sumPoint);
			point.setOrder(invoice);
		}
		return "redirect:/notify";
	}

}
