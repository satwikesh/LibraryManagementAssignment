package exceptions;

public class BookNotThereAtPresetException extends Exception{
    String msg;

    public BookNotThereAtPresetException(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}

