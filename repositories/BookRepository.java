package repositories;

import models.Book;

public interface BookRepository {
    void addBook(int bookId,String title,String author,String genre,boolean availabilityStatus);
    Book[] getAllBooks();
    Book getBookById(int bookId);
    void updateBook(int bookId,String title,boolean availabilityStatus);
    void deleteBook(int id);
}
