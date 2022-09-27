package Exceptions;

public class OutOfSizeException extends RuntimeException{
    public OutOfSizeException(String s){
        System.out.println(s);
    }
}
