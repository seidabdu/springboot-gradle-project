package com.aig.traning.aigtraning.controllerTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import com.acid.aig.traning.aigtraning.controllers.CustomerController;
import com.acid.aig.traning.aigtraning.model.Customer;
import com.acid.aig.traning.aigtraning.service.CustomerService;

@WebMvcTest(CustomerController.class)
public class WebMockCustomerControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerService;

	@LocalServerPort
	int randomServerPort;

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

//		when(customerService.getAllCustomers()).thenReturn(custList);
//		this.mockMvc.perform(get("/get/customers")).andDo(print()).andExpect(status().isOk());

//				.andExpect(content().string(containsString("DC")));

	}
}
