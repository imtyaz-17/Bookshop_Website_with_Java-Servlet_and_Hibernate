package com.bookshop.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookshop.dao.BookDAO;
import com.bookshop.dao.CategoryDAO;
import com.bookshop.entity.Category;

public class CategoryService {
private CategoryDAO categoryDAO;
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	
	public CategoryService(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		
		categoryDAO = new CategoryDAO();
	}
	
	public void listCategory() throws ServletException, IOException {
		listCategory(null);
	}
	
	public void listCategory(String message) throws ServletException, IOException {
		List<Category> listCategory = categoryDAO.listAll();
		
		request.setAttribute("listCategory", listCategory);
		
		if (message != null) {
			request.setAttribute("message", message);
		}
		
		
		String listPage = "category_list.jsp";
		RequestDispatcher requestDispatcher =  request.getRequestDispatcher(listPage);
		requestDispatcher.forward(request, response);
		
	}
	
	
	public void createCategory() throws ServletException, IOException {
		String name = request.getParameter("name");
		
		Category existCategory = categoryDAO.findByName(name);
		
		if (existCategory != null) {
			String message = "Could not Create category." + "A Category with name '" + name + "' alreday exists,!!";
			
			request.setAttribute("message", message);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			requestDispatcher.forward(request, response);
		}
		else {
			Category  newCategory = new Category(name);
			categoryDAO.create(newCategory);
			String message = "New Category Created Successfully";
			listCategory(message);
		}
	}
	
	public void editCategory() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		
		Category category = categoryDAO.get(categoryId);
		request.setAttribute("category", category);
		
		String editPage = "category_form.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(editPage);
		requestDispatcher.forward(request, response);
	}

	public void updateCategory() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String categoryName = request.getParameter("name");
		
		Category categoryById = categoryDAO.get(categoryId);
		Category categoryByName = categoryDAO.findByName(categoryName);
		
		if (categoryByName != null && categoryById.getCategoryId() != categoryByName.getCategoryId()) {
			String message = "Could not Update Category." + "A Category with name '"+ categoryName + "' already exixts.!!";
			
			request.setAttribute("message", message);
			
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("message.jsp");
			requestDispatcher.forward(request, response);
		}
		else {
			
			categoryById.setName(categoryName);
			categoryDAO.update(categoryById);
			
			String message = "Category has been Updated Successfully....!!";
			listCategory(message);
		}
		
	}

	public void deleteCategory() throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("id"));
		BookDAO bookDAO = new BookDAO();
		long numOfBooks = bookDAO.countByCategory(categoryId);
		String message;
		
		if (numOfBooks > 0) {
			message = "Could not Delete the Category (ID: %d) because it currently contains some books";
			message = String.format(message, numOfBooks);
		}
		else {
			categoryDAO.delete(categoryId);
			
			message = "The Category with ID = "+ categoryId + " has been deleted Successfully....!!";
		}
		
		listCategory(message);
		
	}
}
