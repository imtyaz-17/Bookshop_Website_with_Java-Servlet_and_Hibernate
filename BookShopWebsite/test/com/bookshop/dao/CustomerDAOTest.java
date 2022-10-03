package com.bookshop.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookshop.entity.Customer;

public class CustomerDAOTest {

	private static CustomerDAO customerDAO;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		customerDAO = new CustomerDAO();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		customerDAO.close();
	}

	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setEmail("billy.jane@gmail.com");
		customer.setFullname("Jane Billy");
		customer.setCity("New York");
		customer.setCountry("United States");
		customer.setAddress("100 North Avenue");
		customer.setPassword("secret");
		customer.setPhone("18001900");
		customer.setZipcode("100000");
		
		Customer savedCustomer = customerDAO.create(customer);
		
		assertTrue(savedCustomer.getCustomerId() > 0);
	}

	@Test
	public void testUpdateCustomer() {
		Customer customer = customerDAO.get(1);
		String city = "Dhaka";
		customer.setCity(city);
		
		Customer updatedCustomer = customerDAO.update(customer);
		
	assertTrue(updatedCustomer.getCity().equals(city));
	}

	@Test
	public void testGet() {
		Integer customerId = 1;
		Customer customer = customerDAO.get(customerId);
		
		assertNotNull(customer);
	}

	@Test
	public void testDeleteObject() {
		Integer customerId = 1;
		customerDAO.delete(customerId);
		Customer customer = customerDAO.get(1);
		
		assertNull(customer);
	}

	@Test
	public void testListAll() {
		List<Customer> listCustomers = customerDAO.listAll();
		
		for (Customer customer : listCustomers) {
			System.out.println(customer.getFullname());
		}
		
		assertFalse(listCustomers.isEmpty());
	}

	@Test
	public void testCount() {
long totalCustomers = customerDAO.count();
		
		assertEquals(1, totalCustomers);
	}
	@Test
	public void testFindByEmail() {
		String email = "billy.jane@gmail.com";
		Customer customer = customerDAO.findByEmail(email);
		
		assertNotNull(customer);
		
	}
	
	@Test
	public void testCheckLoginSuccess() {
		String email = "billy.jane@gmail.com";
		String password = "secret";
		
		Customer customer = customerDAO.checkLogin(email, password);
		
		assertNotNull(customer);
		
	}
	
	@Test
	public void testCheckLoginFail() {
		String email = "billy.jane@gmail.com";
		String password = "ssss";
		
		Customer customer = customerDAO.checkLogin(email, password);
		
		assertNull(customer);
		
	}	
}
