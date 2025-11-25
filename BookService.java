package com.bookstore;

import java.util.List;

public class BookService {
	private BookDAO dao = new BookDAO();

	public void displayBooks() {
		List<Book> list = dao.getAllBooks();
		System.out.println("\n----- Available Books -----");
		for (Book b : list) {
			System.out.println(b.getId() + " | " + b.getTitle() + " | " + b.getAuthor() + " | Rs." + b.getPrice()
					+ " | Qty: " + b.getQuantity());
		}
	}

	public void buyBook(int id, int qty) {
		Book b = dao.getBookById(id);
		if (b == null) {
			System.out.println("Book not found!");
			return;
		}
		if (b.getQuantity() < qty) {
			System.out.println("Not enough stock!");
			return;
		}

		dao.updateStock(id, qty);
		System.out.println("Purchase successful! Total = Rs." + (b.getPrice() * qty));
	}
}
