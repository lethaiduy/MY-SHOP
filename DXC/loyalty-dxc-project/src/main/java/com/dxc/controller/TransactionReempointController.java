package com.dxc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
public class TransactionReempointController {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private PointRepository pointRepository;
	@Autowired
	private DetailOrderRepository detailOrderRepository;
	@Autowired
	private AccountRepository accountRepository;
	
	@RequestMapping(value = "/transaction2", method = RequestMethod.GET)
	public String transRedeempoint(Model model, Product Product, Order order, Account account, Point point, HttpSession http,
			DetailOrder detailOrder){
		if (null!=http.getAttribute("account")){
			Account acc=(Account)http.getAttribute("account");

			List<Account> listAccount= new ArrayList<>();
			listAccount=accountRepository.findAll();
			for (Account account2 : listAccount) {
				if (account2.getAccountid()==acc.getAccountid())
					model.addAttribute("accountlogin", account2);
			}
			int temp=0;
			List<Point> listPoint = pointRepository.findAll();
			List<Point> lstPoint = new ArrayList<>();
			for (Point point2 : listPoint) {
				if (point2.getOrder().getAccount().getAccountid()==acc.getAccountid() && point2.getPoint()<0){
					lstPoint.add(point2);
					temp=point2.getOrder().getOrderid();
				}
			}
			model.addAttribute("points",lstPoint);
			List<Product> listProduct= new ArrayList<>();
			List<DetailOrder> listDetailOrder=detailOrderRepository.findAll();
			for (DetailOrder detailOrder2 : listDetailOrder) {
				if (detailOrder2.getOrder().getOrderid()==temp){
					listProduct.add(detailOrder2.getProduct());
					model.addAttribute("products",listProduct );
				}
					
			}
			System.out.println(listProduct.size());
			System.out.println(temp);
		}
		return "transaction-redeempoint";
	}
}
