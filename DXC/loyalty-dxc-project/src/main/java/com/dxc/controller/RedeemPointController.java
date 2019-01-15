package com.dxc.controller;

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

import com.dxc.entity.Account;
import com.dxc.entity.DetailOrder;
import com.dxc.entity.Order;
import com.dxc.entity.Point;
import com.dxc.entity.Product;
import com.dxc.repository.AccountRepository;
import com.dxc.repository.DetailOrderRepository;
import com.dxc.repository.OrderRepository;
import com.dxc.repository.PointRepository;
import com.dxc.repository.ProductRepository;

@Controller
@SessionAttributes("account")
public class RedeemPointController {
	@Autowired
	private PointRepository pointRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private DetailOrderRepository detailOrderRepository;
	@Autowired
	private AccountRepository accountRepository;
	int temp = 0;
	List<Product> lstProduct = new ArrayList<>();
	List<Account> listAccount= new ArrayList<>();
	private Account tempAccount;

	@RequestMapping(value = "/redeempoint", method = RequestMethod.GET)
	public String showPages(HttpSession http, Model model) {
		lstProduct.clear();
		List<Product> listProduct = productRepository.findAll();
		if (null != http.getAttribute("account")) {
			Account acc = (Account) http.getAttribute("account");
			/*model.addAttribute("accountlogin", acc);*/

			List<Account> listAccount= new ArrayList<>();
			listAccount=accountRepository.findAll();
			for (Account account2 : listAccount) {
				if (account2.getAccountid()==acc.getAccountid()){
					model.addAttribute("accountlogin", account2);
					temp = account2.getPoint();
					tempAccount=account2;
				}
					
			}
			System.out.println(temp);
			for (Product product : listProduct) {
				if (product.getPoint() <= temp)
					lstProduct.add(product);
			}
			model.addAttribute("products", lstProduct);

		}
		return "redeempoint";
	}

	@RequestMapping(value = "/redeempoint/save", method = RequestMethod.POST)
	public String redeem(@RequestParam(value = "quantity") List<Integer> quantty, Model model, @Valid Order invoice,
			HttpSession http, Point point) {
		int totalPoint = 0;
		if (null != http.getAttribute("account")) {
			Account acc = (Account) http.getAttribute("account");
			
			/*List<Account> listAccount= new ArrayList<>();
			listAccount=accountRepository.findAll();
			for (Account account2 : listAccount) {
				if (account2.getAccountid()==acc.getAccountid()){
					model.addAttribute("accountlogin", account2);
					temp = account2.getPoint();
				}
					
			}*/
			
			
			for (int i = 0; i < lstProduct.size(); i++) {
				totalPoint = totalPoint + (lstProduct.get(i).getPoint() * quantty.get(i));
				System.out.println("point " + lstProduct.get(i).getPoint());
				System.out.println("quantity " + quantty.get(i));
				System.out.println("sum " + totalPoint);
			}
			System.out.println("total" + totalPoint);
			if (totalPoint <= temp && totalPoint != 0) {
				invoice.setAccount(acc);
				invoice.setDate_order(new Date());
				invoice.setTotal_price(new BigDecimal(0));
				orderRepository.save(invoice);

				for (int j = 0; j < lstProduct.size(); j++) {
					if (quantty.get(j) > 0) {
						DetailOrder detail = new DetailOrder();
						detail.setOrder(invoice);
						detail.setProduct(lstProduct.get(j));
						detail.setQuantity(quantty.get(j));
						detailOrderRepository.save(detail);
					}

				}
				accountRepository.updatePoint(tempAccount.getAccountid(), tempAccount.getName(), tempAccount.getAddress(), tempAccount.getCellphone(),
						tempAccount.getEmail(), tempAccount.getPoint() - totalPoint);
				point.setPoint(-totalPoint);
				point.setOrder(invoice);
				pointRepository.save(point);
				return "redirect:/notify";
			}
		} 
		else{
			model.addAttribute("test", "successgdfggdg");
		}
			
		
		return "redirect:/redeempoint";
	}
}
