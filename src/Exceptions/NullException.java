package Exceptions;

public class NullException extends RuntimeException {
    public NullException(String s){
        System.out.println(s);
    }
}