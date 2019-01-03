package com.myshop.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.myshop.model.Customer;
import com.myshop.model.News;
import com.myshop.repository.CustomerRepository;

@Controller
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
	

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String getCustomer(Model model, Customer customer)  {
		model.addAttribute("customer", customerRepository.findAll());
		return "customer-manage";
	}
	@RequestMapping(value = "/customer/save", method = RequestMethod.POST)
	public String save( @Valid Customer customer) throws Exception {
		customerRepository.save(customer);
		return "redirect:/customer";
	}
	@RequestMapping(value = "/customer/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id) {
		Customer result = customerRepository.findByCustomerid(id);
		if (result == null) {
			return "The id not exist";
		}
		customerRepository.delete(result);
		return "redirect:/customer";
	}
	@RequestMapping(value = "/customer/update", method = RequestMethod.POST)
	public String update(@Valid Customer customer) throws IOException {
		customerRepository.updateCustomer(customer.getCustomerid(), customer.getFullname(), customer.getAddress(), customer.getCellphone(), customer.getEmail());
		return "redirect:/customer";

	}
}
