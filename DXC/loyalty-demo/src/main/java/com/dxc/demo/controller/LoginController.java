package com.dxc.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.demo.entity.Account;
import com.dxc.demo.repository.AccountRepository;

@RestController
public class LoginController {
	@Autowired
	private AccountRepository accountRepository;
	
    @RequestMapping(name="/account/list",method=RequestMethod.GET)
	public ResponseEntity<List<Account>> getListAccount(Account account){
    	
    	List<Account> list = accountRepository.findAll();
    	if (list.isEmpty()) {
    		return new ResponseEntity<List<Account>>(HttpStatus.NOT_FOUND);
    	}
    	return new ResponseEntity<List<Account>>(list, HttpStatus.OK);
	}
}
