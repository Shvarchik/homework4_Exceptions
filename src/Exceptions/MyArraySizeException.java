package Exceptions;

public class MyArraySizeException extends MyArrayException {

    String info;

    public String getDimension() {
        return info;
    }

    public MyArraySizeException(String message, String info) {
        super(message);
        this.info = info;
    }
}
