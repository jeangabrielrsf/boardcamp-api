package br.com.boardcamp.boardcamp.exceptions;

public class RentalNotFoundException extends RuntimeException{
    public RentalNotFoundException(String message){
        super(message);
    }
}
