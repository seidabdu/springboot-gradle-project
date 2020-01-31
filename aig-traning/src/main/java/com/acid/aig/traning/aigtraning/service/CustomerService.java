package com.acid.aig.traning.aigtraning.service;

import java.util.List;

import com.acid.aig.traning.aigtraning.model.Customer;

public interface CustomerService {

	public List<Customer> getAllCustomers();
	public Customer findByContactName(String contactName);
	public Customer findByCompanyName(String companyName);
	public Customer addCustomer(Customer customer);
	public String readingList();

}
