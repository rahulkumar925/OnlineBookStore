//Controller Class.
// Controlling following:-
//1.Add items to shopping cart 
//2.Delete items for shopping cart 
//3.Display selected items

package com.cg.os.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cg.os.pojo.Book;
import com.cg.os.service.BookService;
import com.cg.os.service.BookServiceImpl;

@WebServlet("*.app")
public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BookService service = new BookServiceImpl();

	public AppController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		System.out.println(action);
		HttpSession session = request.getSession();
		double sum = 0.0;
		switch (action) {
		case "/homePage.app":
			Collection<Book> books = service.viewBook();
			request.setAttribute("book", books);
			RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
			rd.forward(request, response);
			break;

		case "/addToCart.app":
			int bookId = Integer.parseInt(request.getParameter("productId"));
			books = service.viewBook();
			Book book1 = null;
			for (Book book : books) {
				if (bookId == book.getProductId()) {
					book1 = book;
				}
			}
			service.addToCart(book1);
			Collection<Book> book2 = service.viewCartBooks();
			session.setAttribute("count", book2);
			for (Book book3 : book2) {
				sum += book3.getCost();
			}
			session.setAttribute("sum", sum);
			response.sendRedirect("homePage.app");
			break;

		case "/cart.app":
			books = service.viewCartBooks();
			session.setAttribute("count", books);
			request.setAttribute("book", books);
			for (Book book3 : books) {
				sum += book3.getCost();
			}
			session.setAttribute("sum", sum);
			rd = request.getRequestDispatcher("Cart.jsp");
			rd.forward(request, response);
			break;

		case "/delete.app":
			bookId = Integer.parseInt(request.getParameter("productId"));
			books = service.viewCartBooks();
			book1 = null;
			for (Book book : books) {
				if (bookId == book.getProductId()) {
					book1 = book;
				}
			}
			service.deleteBook(book1);
			response.sendRedirect("cart.app");
		default:
			break;

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
