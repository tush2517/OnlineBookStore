package com.bookstore;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		BookService service = new BookService();
		BookDAO dao = new BookDAO();

		while (true) {
			System.out.println("\n===== ONLINE BOOK STORE =====");
			System.out.println("1. Add Book (Admin)");
			System.out.println("2. View Books");
			System.out.println("3. Buy Book");
			System.out.println("4. Exit");
			System.out.print("Choose option: ");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				System.out.print("Enter title: ");
				sc.nextLine();
				String title = sc.nextLine();

				System.out.print("Enter author: ");
				String author = sc.nextLine();

				System.out.print("Enter price: ");
				double price = sc.nextDouble();

				System.out.print("Enter quantity: ");
				int qty = sc.nextInt();

				Book b = new Book(0, title, author, price, qty);
				dao.addBook(b);
				System.out.println("Book Added!");
				break;

			case 2:
				service.displayBooks();
				break;

			case 3:
				System.out.print("Enter Book ID: ");
				int id = sc.nextInt();
				System.out.print("Enter Quantity: ");
				int q = sc.nextInt();
				service.buyBook(id, q);
				break;

			case 4:
				System.out.println("Thanks for visiting!");
				System.exit(0);

			default:
				System.out.println("Invalid option!");
			}
		}
	}
}
