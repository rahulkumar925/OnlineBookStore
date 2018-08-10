//Interface of BookDAO

package com.cg.os.dao;

import java.util.Collection;

import com.cg.os.pojo.Book;

public interface BookDAO {

	void addToCart(Book book);

	Book getBookById(int bookId);

	void deleteBook(Book book);

	Collection<Book> viewCartBooks();

	Collection<Book> viewBook();

}