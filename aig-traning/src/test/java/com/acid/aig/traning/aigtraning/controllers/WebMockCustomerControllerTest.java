package com.acid.aig.traning.aigtraning.controllers;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.acid.aig.traning.aigtraning.model.Customer;
import com.acid.aig.traning.aigtraning.service.CustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebMockCustomerControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerService;



	@Test
	public void greetingShouldReturnMessageFromService() throws Exception {

		List<Customer> custList = new ArrayList<>();

		Customer cust1 = new Customer();
		cust1.setCity("Charlotte");
		Customer cust2 = new Customer();
		cust1.setCity("durham");
		Customer cust3 = new Customer();
		cust1.setCity("DC");
		custList.add(cust1);
		custList.add(cust2);
		custList.add(cust3);

		when(customerService.getAllCustomers()).thenReturn(custList);
		this.mockMvc.perform(get("/get/customers")).andDo(print()).andExpect(status().isOk())

				.andExpect(content().string(containsString("DC")));

	}
}
