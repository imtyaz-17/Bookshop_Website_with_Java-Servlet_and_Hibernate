package com.bookshop.dao;

import java.util.Date;
import java.util.List;

import com.bookshop.entity.Book;

public class BookDAO extends JpaDAO<Book> implements GenericDAO<Book> {

	public BookDAO() {
		
	}

	@Override
	public Book create(Book book) {
		book.setLastUpdateTime(new Date());
		return super.create(book);
	}

	@Override
	public Book update(Book book) {
		book.setLastUpdateTime(new Date());
		return super.update(book);
	}

	@Override
	public Book get(Object bookId) {
		
		return super.find(Book.class, bookId);
	}

	@Override
	public void delete(Object bookId) {
		super.delete(Book.class, bookId);
		
	}

	@Override
	public List<Book> listAll() {
		
		return super.findWithNamedQuery("Book.findAll");
	}

	public Book findByTitle(String title) {
		List<Book> resultBooks = super.findWithNamedQuery("Book.findByTitle","title", title);
		
		if (!resultBooks.isEmpty()) {
			return resultBooks.get(0);
		}
		return null;
	}
	
	public List<Book> listByCategory(int categoryId){
		return super.findWithNamedQuery("Book.findByCategory","catId",categoryId);
	}
	
	public List<Book> searchBook(String keyword){
		return super.findWithNamedQuery("Book.search","keyword" , keyword);
	}
	
	public List<Book> listNewBooks(){
		return super.findWithNamedQuery("Book.listNewBook", 0, 4);
	}
	
	@Override
	public long count() {
		return super.countWithNamedQuery("Book.countAll");
	}
	
	public long countByCategory(int categoryId) {
		return  super.countWithNamedQuery("Book.countByCategory", "catId", categoryId);
	}

}