package repositories;

import models.Book;

import java.sql.*;

public class BookRepositoryImpl implements BookRepository{

    private int noBooks;

    private final String url="jdbc:mysql://127.0.0.1:3306/libraryManagement";
    private final  String user="root";
    private final  String password="9247841118bunny";//Enter your password of mysql database here

    public BookRepositoryImpl() {

        try ( Connection connection = DriverManager.getConnection(url, user, password)){


            String insertQuery="SELECT COUNT(*) FROM books;";
            Statement statement=connection.createStatement();

            ResultSet resultSet=statement.executeQuery(insertQuery);
            while (resultSet.next()){
                this.noBooks=resultSet.getInt(1);
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }


    }

    @Override
    public void addBook(int bookId, String title, String author, String genre, boolean availabilityStatus) {
        try ( Connection connection = DriverManager.getConnection(url, user, password)){



            String insertQuery="insert into books (bookId,title,author,genre,availabilityStatus) values(?,?,?,?,?);";
            PreparedStatement preparedStatement=connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1,bookId);
            preparedStatement.setString(2,title);
            preparedStatement.setString(3,author);
            preparedStatement.setString(4,genre);
            preparedStatement.setBoolean(5,true);
            preparedStatement.executeUpdate();

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        noBooks++;
    }

    @Override
    public Book[] getAllBooks() {
        Book[] allBooks=new Book[noBooks];

        try ( Connection connection = DriverManager.getConnection(url, user, password)){


            Statement statement=connection.createStatement();

            String query="SELECT * FROM books;";
            ResultSet resultSet=statement.executeQuery(query);
            int j=0;
            while (resultSet.next()){
                int bookId=resultSet.getInt("bookId");
                String title=resultSet.getString("title");
                String author=resultSet.getString("author");
                String genre=resultSet.getString("genre");
                boolean availabilityStatus = resultSet.getBoolean("availabilityStatus");

                allBooks[j]=new Book(bookId,title,author,genre,availabilityStatus);
                j++;
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return allBooks;
    }

    @Override
    public Book getBookById(int bookId) {

        try ( Connection connection = DriverManager.getConnection(url, user, password)){


            Statement statement=connection.createStatement();

            String query="SELECT * FROM books where bookId="+bookId;
            ResultSet resultSet=statement.executeQuery(query);

            while (resultSet.next()){
                int id=resultSet.getInt("bookId");
                String title=resultSet.getString("title");
                String author=resultSet.getString("author");
                String genre=resultSet.getString("genre");
                boolean availabilityStatus=resultSet.getBoolean("availabilityStatus");


                Book  book= new Book(bookId,title,author,genre,availabilityStatus);
                return book;
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return null;//book not found

    }

    @Override
    public void updateBook(int bookId, String title, boolean availabilityStatus) {
        try ( Connection connection = DriverManager.getConnection(url, user, password)){
            String UPDATE_SQL = "UPDATE books SET title = ?, availabilityStatus = ? WHERE bookId = ?";
            PreparedStatement preparedStatement=connection.prepareStatement(UPDATE_SQL);
            preparedStatement.setString(1,title);
            preparedStatement.setBoolean(2,availabilityStatus);
            preparedStatement.setInt(3,bookId);
            int rowsAffected =preparedStatement.executeUpdate();






        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBook(int bookId) {
        try ( Connection connection = DriverManager.getConnection(url, user, password)){
            String DELETE_SQL = "DELETE FROM books WHERE bookId = ?";
            PreparedStatement preparedStatement=connection.prepareStatement(DELETE_SQL);
            preparedStatement.setInt(1,bookId);
            preparedStatement.executeUpdate();

            noBooks--;




        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
}
