//Interface of BookService.

package com.cg.os.service;

import java.util.Collection;

import com.cg.os.pojo.Book;

public interface BookService {

	void addToCart(Book book);

	Book getBookById(int bookId);

	void deleteBook(Book book);

	Collection<Book> viewCartBooks();

	Collection<Book> viewBook();

}