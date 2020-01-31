package com.acid.aig.traning.aigtraning.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acid.aig.traning.aigtraning.service.CustomerService;

@RestController
public class ApiContoller {

	@Autowired
	public CustomerService customerService;

	@RequestMapping(value = "/reading", method = RequestMethod.GET, produces = MediaType.ALL_VALUE)
	public String getReadingList() {

		return customerService.readingList();

	}

}
