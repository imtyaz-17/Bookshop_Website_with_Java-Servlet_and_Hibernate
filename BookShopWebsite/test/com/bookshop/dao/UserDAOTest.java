package com.bookshop.dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookshop.entity.Users;

public class UserDAOTest {
	private static UserDAO userDAO;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userDAO = new UserDAO();
	}
	
	@AfterClass
	public static void tearDownClass() throws Exception {
		userDAO.close();
	}
	
	@Test
	public void testCreateUsers() {
		
		Users user1 = new Users();
		
        user1.setEmail("i@gmail.com");
        user1.setFullName("Immtyaz");
        user1.setPassword("123");
        
        user1 = userDAO.create(user1);
        
        assertTrue(user1.getUserId()>0);
	}
	
	@Test(expected = PersistenceException.class)
	public void testCreateUsersFieldsNotSet() {
		
		Users user1 = new Users();
		user1 = userDAO.create(user1);
	}
	
	@Test 
	public void testUpdateUsers() {
		
		Users user = new Users();
		
		user.setUserId(1);
		user.setEmail("i@gmail.com");
        user.setFullName("Immtyaz");
        user.setPassword("123");
		
		user = userDAO.update(user);
		String expected = "123";
		String actual = user.getPassword();
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testGetUsersFound() {
		
		Integer userId = 1;
		Users user = userDAO.get(userId);
		
		assertNotNull(user);
	}
	
	@Test
	public void testDeleteUsers() {
		
		Integer userId = 2;
		userDAO.delete(userId);
		
		Users user = userDAO.get(userId);
		
		assertNotNull(user);
		
	}
	
	@Test(expected = EntityNotFoundException.class)
	public void testDeleteNotExistUsers() {
		
		Integer userId = 2;
		userDAO.delete(userId);
		
	}
	@Test
	public  void testListAll() {
		List<Users> listUsers = userDAO.listAll();
		
		for(Users users : listUsers) {
			System.out.println(users.getFullName());
		}
		
		assertTrue(listUsers.size() > 0);
	}
	
	@Test
	public void testFindByEmail() {
		String email = "i@gmail.com";
		Users users = userDAO.findByEmail(email);
		
		assertNotNull(users);

	}
	
	
	@Test
	public void testCount() {
		long totalUsers = userDAO.count();
		
		assertTrue(totalUsers > 0);
	}
	
	@Test
	public void testCheckLoginSuccess() {
		String email = "imtyaz@gmail.com";
		String password = "123" ;
		
		boolean loginResult = userDAO.checkLogin(email, password);
		
		assertTrue(loginResult);
	}
	
	@Test
	public void testCheckLoginFailed() {
		String email = "imtyaz@gmail.com";
		String password = "12333" ;
		
		boolean loginResult = userDAO.checkLogin(email, password);
		
		assertFalse(loginResult);
	}
	

}