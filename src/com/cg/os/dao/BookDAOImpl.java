//Implementation of Book Interface.

package com.cg.os.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import com.cg.os.pojo.Book;

public class BookDAOImpl implements BookDAO {

	Map<Integer, Book> bookDB = new HashMap<>();
	Map<Integer, Book> cartDB = new HashMap<>();

	@Override
	public void addToCart(Book book) {
		cartDB.put(book.getProductId(), book);
	}

	@Override
	public Collection<Book> viewCartBooks() {
		return cartDB.values();
	}

	@Override
	public Book getBookById(int bookId) {

		return cartDB.get(bookId);

	}

	@Override
	public void deleteBook(Book book) {
		cartDB.remove(book.getProductId());
	}

	@Override
	public Collection<Book> viewBook() {
		bookDB.put(1, new Book(1, "Java 8", "Core Java Concepts", 800));
		bookDB.put(2, new Book(2, "HTML", "HTML5 Concepts", 400));
		bookDB.put(3, new Book(3, "Spring", "Spring MVC Layered Architecture", 1000));
		bookDB.put(4, new Book(4, "Servlets & JSP", "JEE Fundamentals", 600));
		bookDB.put(5, new Book(5, "Let us C", "C Fundamentals", 300));
		return bookDB.values();

	}

}