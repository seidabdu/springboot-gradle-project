package com.acid.aig.traning.aigtraning.service;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.acid.aig.traning.aigtraning.model.Customer;
import com.acid.aig.traning.aigtraning.repository.CustomerRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	public CustomerRepository customerRespository;

	@Override
	public List<Customer> getAllCustomers() {
		return customerRespository.findAll();
	}

	@Override
	public Customer findByContactName(String companyName) {

		return customerRespository.findByContactName(companyName);
	}

	@Override
	public Customer findByCompanyName(String companyName) {

		return customerRespository.findByCompanyName(companyName);
	}

	@Override
	public Customer addCustomer(Customer customer) {
		Customer savedCustomer = customerRespository.save(customer);
		return savedCustomer;
	}

	@HystrixCommand(fallbackMethod = "reliable")
	public String readingList() {
		URI uri = URI.create("http://localhost:8090/recommended");
		return this.restTemplate.getForObject(uri, String.class);
	}

	public String reliable() {
		return "Cloud Native Java (O'Reilly)";
	}

}
