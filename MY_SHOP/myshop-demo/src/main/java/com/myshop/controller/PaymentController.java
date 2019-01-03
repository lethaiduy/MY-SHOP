package com.myshop.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
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

import com.myshop.model.Customer;
import com.myshop.model.DetailOrder;
import com.myshop.model.Order;
import com.myshop.model.PaymentMethod;
import com.myshop.model.Product;
import com.myshop.repository.CustomerRepository;
import com.myshop.repository.DetailOrderRepository;
import com.myshop.repository.OrderRepository;
import com.myshop.repository.PaymentMethodRepository;
import com.myshop.repository.ProductGrpRepositoy;
import com.myshop.repository.ProductsRepository;

@Controller
@SessionAttributes("prodlist1")
public class PaymentController {
	@Autowired
	PaymentMethodRepository paymentMethodRepository;

	@Autowired
	ProductsRepository productsRepository;

	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	PaymentMethodRepository paymentmethodRepository;
	
	@Autowired
	DetailOrderRepository detailOrderRepository;
	
	@Autowired
	ProductGrpRepositoy productgrpRepository;
	

	@RequestMapping(value = "/payment", method = RequestMethod.GET)
	public String getPayment(Model model, HttpSession http) {
		/* model.addAttribute("orders", orderRepository.findAll()); */
		if (http.getAttribute("prodlist1") != null) {

			@SuppressWarnings("unchecked")
			Product products = (Product) (http.getAttribute("prodlist1"));
			List<Product> listPrd = new ArrayList<>();
			listPrd.add(products);
			for (Product product : listPrd) {
				System.out.println(product.getProdname());
			}
			System.out.println(listPrd.size());
			model.addAttribute("prdPayment", listPrd);
			http.setAttribute("prodlist2", listPrd);

		} else
			System.out.println("null");
		model.addAttribute("paymentmethod", paymentMethodRepository.findAll());
		model.addAttribute("productgrps", productgrpRepository.findAll());
		return "payment-user";
	}

	@RequestMapping(value = "/payment/save", method = RequestMethod.POST)
	public String save(@Valid Order order, @Valid Customer customer,@Valid PaymentMethod paymentMethod,@Valid DetailOrder detailOrder,@Valid Product product) throws Exception {
        customerRepository.save(customer);
        order.setDate_order(new Date());
        order.setStatus("Chưa Xữ Lý");
        order.setCustomer(customer);
		orderRepository.save(order);
		detailOrder.setQuantity(1);
		detailOrder.setOrder(order);
		detailOrderRepository.save(detailOrder);
		return "redirect:/payment";
	}

}
