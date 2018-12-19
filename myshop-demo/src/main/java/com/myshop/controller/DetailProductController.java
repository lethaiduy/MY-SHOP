package com.myshop.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.myshop.model.Product;
import com.myshop.repository.ProductGrpRepositoy;
import com.myshop.repository.ProductsRepository;
import com.myshop.repository.SizeRepository;

@Controller
@SessionAttributes("product")
public class DetailProductController {
	@Autowired
	ProductsRepository productsRepository;
	@Autowired
	SizeRepository sizeRepository;
	@Autowired
	ProductGrpRepositoy productgrpRepository;

	@RequestMapping(value = "/detailproduct", method = RequestMethod.GET)
	public String getProduct(Model model, Product product,HttpSession http) {
 
        Product products= (Product)http.getAttribute("product");
        model.addAttribute("productlist", products);
        model.addAttribute("sizes",sizeRepository.findAll());
        model.addAttribute("productgrps", productgrpRepository.findAll());
        http.setAttribute("prodlist1", products);
     
		return "detailprod-guest";
	}

	@RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	public String findByProductId(@PathVariable("id") int id, Model model) {
		Product result = productsRepository.findByProdid(id);
		model.addAttribute("product", result);
		return "redirect:/detailproduct";
	}
}
