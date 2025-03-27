package exceptions;

public class BookIdExist extends  Exception{
    String msg;

    public BookIdExist(String msg) {

        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
