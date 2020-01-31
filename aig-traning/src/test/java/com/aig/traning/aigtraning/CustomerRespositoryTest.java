package com.aig.traning.aigtraning;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.acid.aig.traning.aigtraning.model.Customer;
import com.acid.aig.traning.aigtraning.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRespositoryTest {

	@Autowired
	CustomerRepository cusRepository;

	@Test
	public void testAddCustomer() throws Exception {

		Customer customer = new Customer();
		customer.setAddress("4925 central ave apt 9");
		customer.setCity("Durham");
		customer.setCompanyName("AIG");
		customer.setContactName("Manish");
		customer.setZip("27703");
		customer.setCountry("USA");

		Customer savedCustomer = cusRepository.save(customer);
		System.out.println("Saved Customer" + savedCustomer.getAddress());
		List<Customer> listOfCust = cusRepository.findAll();

		assertEquals(1, listOfCust.size());
		assertNotNull(listOfCust.get(0));

//		assertEquals("DC", customer.get(0).getCity());
//		assertEquals(3, customer.size());
//		System.out.println(customer.get(0).getCity());
	}

	@Test
	public void testGetCustomer() throws Exception {
		List<Customer> customer = cusRepository.findAll();

		assertEquals(1, customer.size());
//		assertNotNull(customer.get(0));

//		assertEquals("DC", customer.get(0).getCity());
//		assertEquals(3, customer.size());
//		System.out.println(customer.get(0).getCity());
	}

}
