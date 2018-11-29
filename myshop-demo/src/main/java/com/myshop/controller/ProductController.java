package com.myshop.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.myshop.model.News;
import com.myshop.model.Product;
import com.myshop.model.Size;
import com.myshop.repository.ProductGrpRepositoy;
import com.myshop.repository.ProductsRepository;
import com.myshop.repository.SizeRepository;

@Controller
public class ProductController {
	@Autowired
	ProductsRepository productsRepository;
	@Autowired
	ProductGrpRepositoy productsgrpRepository;
	@Autowired
	SizeRepository sizeRepository;

	@RequestMapping(value = "/product", method = RequestMethod.GET)
	public String getProduct(Model model,News news) {
		model.addAttribute("product", productsRepository.findAll());
		model.addAttribute("productgrp", productsgrpRepository.findAll());
		model.addAttribute("sizes", sizeRepository.findAll());
		return "product-manager";
	}

	@RequestMapping(value = "/product/save", method = RequestMethod.POST)
	public String save(@Valid @RequestParam MultipartFile[] images, @Valid Product products,@Valid Size sizes) throws Exception {
		if (images != null && images.length > 0) {
			for (MultipartFile aFile : images) {
				products.setImage(aFile.getBytes());
			}
		}
		productsRepository.save(products);
		/*sizeRepository.save(sizes);*/
		return "redirect:/product";
	}

	@RequestMapping(value = "/product/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {

		/*Size rsByPrd = sizeRepository.findByProductesProdid(id);*/
		Product result = productsRepository.findByProdid(id);
		if (result == null ) {
			return "The id not exist";
		}
		/*sizeRepository.delete(rsByPrd);*/
		productsRepository.delete(result);

		return "redirect:/product";
	}
	@RequestMapping(value = "/product/update", method = RequestMethod.POST)
	public String  update( Product product) {
		productsRepository.updateProduct(product.getProdid(), product.getProdname(), product.getBrand(), product.getFabric(), product.getPrice(), product.getQuantity(), product.getImage(), product.getProductGrp().getProdgrpid());
		return "redirect:/product";

	}

}
