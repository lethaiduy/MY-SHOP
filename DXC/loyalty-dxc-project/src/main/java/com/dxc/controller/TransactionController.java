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
import com.dxc.repository.DetailOrderRepository;
import com.dxc.repository.OrderRepository;
import com.dxc.repository.PointRepository;

@Controller
public class TransactionController {

	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private PointRepository pointRepository;
	@Autowired
	private DetailOrderRepository detailOrderRepository;

	@RequestMapping(value = "/transaction", method = RequestMethod.GET)
	public String showPages(Model model, Product Product, Order order, Account account, Point point, HttpSession http,
			DetailOrder detailOrder) {
		/*List<Point> listPoint = pointRepository.findAll();
		List<DetailOrder> list= detailOrderRepository.findAll();
		model.addAttribute("points",listPoint);
		List<Product> listProduct= new ArrayList<>();
	    for (Point point2 : listPoint) {
			for (DetailOrder detailOrder2 : list) {
				if (detailOrder2.getOrder().getOrderid()==point2.getOrder().getOrderid()){
					listProduct.add(detailOrder2.getProduct());
				}
				model.addAttribute("products",listProduct );
				System.out.println(listProduct.size());
				
			}
		}	*/
		if (null!=http.getAttribute("account")){
			Account acc=(Account)http.getAttribute("account");
			int temp=0;
			List<Point> listPoint = pointRepository.findAll();
			List<Point> lstPoint = new ArrayList<>();
			for (Point point2 : listPoint) {
				if (point2.getOrder().getAccount().getAccountid()==acc.getAccountid()){
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

		return "transaction";
	}
}
