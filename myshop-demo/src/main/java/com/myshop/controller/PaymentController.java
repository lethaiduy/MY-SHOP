package com.myshop.controller;

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

import com.myshop.model.News;
import com.myshop.model.Order;
import com.myshop.model.Product;
import com.myshop.repository.NewsRepository;
import com.myshop.repository.PaymentMethodRepository;
import com.myshop.repository.ProductsRepository;

@Controller
@SessionAttributes("prodlist1")
public class PaymentController {
	@Autowired
	PaymentMethodRepository paymentMethodRepository;
	@Autowired
	ProductsRepository productsRepository;
	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String getPayment(Model model, HttpSession http) {
		/* model.addAttribute("orders", orderRepository.findAll()); */
		if (http.getAttribute("prodlist1") != null) {
			
			@SuppressWarnings("unchecked")
			Product products = (Product) (http.getAttribute("prodlist1"));
			List<Product> listPrd= new ArrayList<>();
			listPrd.add(products);
			for (Product product : listPrd) {
				System.out.println(product.getProdname());
			}
			System.out.println(listPrd.size());
			model.addAttribute("prdPayment", listPrd);
			
		}
		else System.out.println("null");
		model.addAttribute("paymentmethod", paymentMethodRepository.findAll());
		return "payment-user";
	}
	/*@RequestMapping(value = "/payment/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		Product result = productsRepository.findByProdid(id);
		if (result == null) {
			return "The id not exist";
		}
		productsRepository.delete(result);
		return "redirect:/payment";
	}*/
}
