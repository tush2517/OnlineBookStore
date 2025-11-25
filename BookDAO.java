package com.bookstore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	public int addBook(Book b) {
		int result = 0;
		String sql = "insert into books(title, author, price, quantity) values(?, ?, ?, ?)";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, b.getTitle());
			ps.setString(2, b.getAuthor());
			ps.setDouble(3, b.getPrice());
			ps.setInt(4, b.getQuantity());

			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Book> getAllBooks() {
		List<Book> list = new ArrayList<>();
		String sql = "SELECT * FROM books";

		try (Connection con = DBConnection.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				Book b = new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getDouble("price"),
						rs.getInt("quantity"));
				list.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Book getBookById(int id) {
		Book b = null;
		String sql = "SELECT * FROM books WHERE id=?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				b = new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getDouble("price"),
						rs.getInt("quantity"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

	public int updateStock(int id, int qty) {
		String sql = "UPDATE books SET quantity = quantity - ? WHERE id=?";
		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setInt(1, qty);
			ps.setInt(2, id);
			return ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
