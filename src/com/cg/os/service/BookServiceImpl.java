//Implementation of BookService.

package com.cg.os.service;

import java.util.Collection;

import com.cg.os.dao.BookDAO;
import com.cg.os.dao.BookDAOImpl;
import com.cg.os.pojo.Book;

public class BookServiceImpl implements BookService {

	private BookDAO dao = new BookDAOImpl();

	@Override
	public void addToCart(Book book) {
		dao.addToCart(book);

	}

	@Override
	public Book getBookById(int bookId) {
		return dao.getBookById(bookId);
	}

	@Override
	public void deleteBook(Book book) {
		dao.deleteBook(book);

	}

	@Override
	public Collection<Book> viewCartBooks() {

		return dao.viewCartBooks();
	}

	@Override
	public Collection<Book> viewBook() {

		return dao.viewBook();
	}

}
