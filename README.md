Online Book Store (Java Console Project)

A simple console-based Online Book Store built using Java + JDBC + MySQL.
Users can view, search, and buy books. Admin can add and manage books.

Features

Add Book

View Books

Search Book

Buy Book


Technologies

Java

JDBC

MySQL

Eclipse IDE


Database

CREATE DATABASE onlinebookstore;

CREATE TABLE books (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(100),
  author VARCHAR(100),
  price DOUBLE,
  quantity INT
);

How to Run

1. Add MySQL Connector JAR to Build Path


2. Update DBConnection.java with your MySQL username & password


3. Run Main.java
