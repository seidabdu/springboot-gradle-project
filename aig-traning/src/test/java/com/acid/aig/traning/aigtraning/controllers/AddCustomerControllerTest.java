package com.acid.aig.traning.aigtraning.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.acid.aig.traning.aigtraning.model.Customer;
import com.acid.aig.traning.aigtraning.service.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AddCustomerControllerTest {
	
	 @Autowired
	  private MockMvc mockMvc;
	 
	 @Autowired
	  private ObjectMapper objectMapper;
	 
	 @Autowired
	 CustomerService  cusomerService;
	 
	 @Test
	 public void registrationWorksThroughAllLayers() throws Exception {
			Customer customer = new Customer();
			customer.setAddress("4925 central ave apt 9");
			customer.setCity("Durham");
			customer.setCompanyName("AIG");
			customer.setContactName("Manish");
			customer.setZip("27703");
			customer.setCountry("USA");

	    mockMvc.perform(post("/add/customer")
	            .contentType("application/json")	         
	            .content(objectMapper.writeValueAsString(customer)))
	            .andExpect(status().isOk());

	    Customer retrivedCustomer = cusomerService.findByContactName("Manish");
	    System.out.println(retrivedCustomer.getAddress());
	    assertThat(retrivedCustomer.getContactName()).isEqualTo("Manish");
	  }
	 

}
