# LibraryManagementAssignment


## Introduction

The Library Book Management System is a console-based application developed in Java with MySQL integration. It allows librarians to efficiently manage books by adding, updating, searching, and removing book records while maintaining their availability status.

## Features

- *Add a Book*: Insert a new book record with Book ID, Title, Author, Genre, and Availability Status.
- *View All Books*: Display a list of all stored books.
- *Search a Book: Find books using their **ID* or *Title*.
- *Update Book Details*: Modify book attributes (availability status, title, author, etc.).
- *Delete a Book*: Remove a book from the database.
- *Exit System*: Close the application.

## Technologies Used

- *Programming Language*: Java
- *Database*: MySQL
- *Database Connectivity*: JDBC (Java Database Connectivity)

## Database Setup

1. Install MySQL Server if not already installed.
2. open MySql Create a database named library_db using:
   ```sql
   create database libraryManagement;
3. next create books table using:
   ```sql
     use libraryManagement;
     CREATE TABLE books (
      bookId INT PRIMARY KEY,
      title VARCHAR(255) NOT NULL,
      author VARCHAR(255) NOT NULL,
      genre VARCHAR(100),
      availabilityStatus BOOLEAN
    );
5. clone the project to your local repository using command:
    ```bash
   git clone  https://github.com/satwikesh/LibraryManagementAssignment.git
   cd LibraryManagementAssignment
6.after cloning go to repositories directory then go to BookRepositoriesImpl.java file and connect the database to your 
  local libraryManagement:
  ```java
  private final String url="jdbc:mysql://127.0.0.1:3306/libraryManagement";
  private final String user = "your_mysql_username";
  private finalString password = "your_mysql_password";
