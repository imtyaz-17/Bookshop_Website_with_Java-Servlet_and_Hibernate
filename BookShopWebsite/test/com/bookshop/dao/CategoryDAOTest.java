package com.bookshop.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.bookshop.entity.Category;

public class CategoryDAOTest {
	private static CategoryDAO categoryDAO;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testCreateCategory() {
		Category newCategory = new Category("C++");
		Category category = categoryDAO.create(newCategory);
		
		assertTrue(category != null && category.getCategoryId()>0);
	}

	@Test
	public void testUpdateCategory() {
		Category cate = new Category("C#");
		cate.setCategoryId(1);
		
		Category category = categoryDAO.update(cate);
		
		assertEquals(cate.getName(), category.getName());
	}

	@Test
	public void testGet() {
		Integer catId = 2;
		Category category = categoryDAO.get(catId);
		
		assertNotNull(category);
	}

	@Test
	public void testDeleteCategory() {
		Integer catId = 3;
		categoryDAO.delete(catId);
		
		Category cat = categoryDAO.get(catId);
		
		assertNull(cat);
		
	}

	@Test
	public void testListAll() {
		List<Category>  listCategory = categoryDAO.listAll();
		
		listCategory.forEach(c -> System.out.println(c.getName() + ","));
		
		assertTrue(listCategory.size() > 0);
	}

	@Test
	public void testCount() {
		long totalCategories = categoryDAO.count();
		
		assertTrue(totalCategories > 0);
	}
	
	@Test
	public void testFindByName() {
		String name = "C++";
		Category category = categoryDAO.findByName(name);
		
		assertNotNull(category);
	}
	
	@Test
	public void testFindByNameNotFound() {
		String name = "C++++";
		Category category = categoryDAO.findByName(name);
		
		assertNull(category);
	}

}
