package com.bookshop.controller.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookshop.dao.BookDAO;
import com.bookshop.entity.Book;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BookDAO bookDAO = new BookDAO();
		List<Book> listNewBooks = bookDAO.listNewBooks();
		request.setAttribute("listNewBooks", listNewBooks);

		String homepage = "frontend/index.jsp";

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(homepage);
		System.out.println("***********Now I'm in Home Page***************");
		requestDispatcher.forward(request, response);
	}

}
