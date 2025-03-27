package exceptions;

public class BookNotFoundException extends Exception{
    String msg;

    public BookNotFoundException(String msg) {

        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
