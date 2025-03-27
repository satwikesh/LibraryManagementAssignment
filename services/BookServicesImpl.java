package services;

import exceptions.BookIdExist;
import exceptions.BookNotFoundException;
import exceptions.BookNotThereAtPresetException;
import models.Book;
import repositories.BookRepository;

public class BookServicesImpl implements BookServices{
    private BookRepository bookRepository;

    public BookServicesImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void addBook(int bookId, String title, String author, String genre, boolean availabilityStatus) {
         Book[] books=getAllBooks();
         if(books!=null){
             int b=0;
             try {
                 for (int i = 0; i <books.length ; i++) {
                     if(books[i].getBookId()==bookId){ b=1;
                         throw new BookIdExist("the entered Book id already exists");

                     }
                 }
             }
             catch (BookIdExist bookIdExist){
                 System.out.println(bookIdExist);
             }
           if(b==0) bookRepository.addBook(bookId,title,author,genre,availabilityStatus);
         }
        else  bookRepository.addBook(bookId,title,author,genre,availabilityStatus);
    }

    @Override
    public Book[] getAllBooks() {
        return bookRepository.getAllBooks();
    }

    @Override
    public Book getBookById(int bookId) {
        Book book=bookRepository.getBookById(bookId);


        try {
            if(book!=null){
                return book;
            }
            else {
                throw new BookNotFoundException("Enter valid book id");
            }
        }

        catch(BookNotFoundException bnfe){
            System.out.println(bnfe);

        }
        return  null;
    }

    @Override
    public void updateBook(int bookId, String title, boolean availabilityStatus) {
        Book book=bookRepository.getBookById(bookId);
        try {
            if(book!=null){
                bookRepository.updateBook(bookId,title,availabilityStatus);
            }
            else {
                throw new BookNotFoundException("Enter valid book id");
            }
        }
        catch(BookNotFoundException bnfe){
            System.out.println(bnfe);
        }

    }

    @Override
    public void deleteBook(int id) {
        Book book=bookRepository.getBookById(id);
        try {

            if(book==null){
                throw new BookNotFoundException("Enter valid book id");
            }
            if(!book.isAvailabilityStatus()){
                throw new BookNotThereAtPresetException("Book is not there at present to delete ");
            }

            bookRepository.deleteBook(id);
        }
        catch(BookNotFoundException bookNotFoundException){
            System.out.println(bookNotFoundException);
        }
        catch (BookNotThereAtPresetException bookNotThereAtPresetException){
            System.out.println(bookNotThereAtPresetException);
        }
    }
}
