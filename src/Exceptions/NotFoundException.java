package Exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String s){
        System.out.println(s);
    }
}
