package controller;

import models.Book;
import repositories.BookRepository;
import repositories.BookRepositoryImpl;
import services.BookServices;
import services.BookServicesImpl;

import java.util.Scanner;

public class MainController {
    BookRepository bookRepository=new BookRepositoryImpl();
    BookServices bookServices=new BookServicesImpl(bookRepository);

    public void run(){
        Scanner scan=new Scanner(System.in);
        while (true){
            System.out.println("1. Add Books ");
            System.out.println("2. get all books");
            System.out.println("3. get book by id");
            System.out.println("4. updateBook");
            System.out.println("5. deleteBook");
            System.out.println("6. Exit");
            int choice=scan.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Enter Book Id:");
                    int bookId=scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter title");
                    String title=scan.nextLine();
                    System.out.println("Enter author");
                    String  author=scan.nextLine();
                    System.out.println("Enter genre");
                    String genre=scan.nextLine();
                    bookServices.addBook(bookId,title,author,genre,true);
                    break;
                case 2:
                    Book[] books=bookServices.getAllBooks();
                    for (int i = 0; i <books.length ; i++) {
                        System.out.println(books[i]);
                    }
                    if(books.length==0)
                        System.out.println("no books there ");
                    break;
                case 3:
                    System.out.println("Enter Book Id:");
                    bookId=scan.nextInt();
                    System.out.println(bookServices.getBookById(bookId));
                    break;
                case 4:
                    System.out.println("Enter Book Id:");
                    bookId=scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter New title");
                    String newTitle=scan.nextLine();
                    System.out.println("Enter Available Status true or false");
                    boolean availabilityStatus=scan.nextBoolean();
                    bookServices.updateBook(bookId,newTitle,availabilityStatus);
                    break;
                case 5:
                    System.out.println("Enter Book Id:");
                    bookId=scan.nextInt();
                    bookServices.deleteBook(bookId);
                    break;
                case 6:
                    System.out.println("Exiting ...");
                    return;
                default:
                    System.out.println("Enter Correct Option");

            }
        }
    }
}
