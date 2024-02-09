package br.com.boardcamp.boardcamp.exceptions;

public class RentalAlreadyFinished extends RuntimeException{
    public RentalAlreadyFinished(String message) {
        super(message);
    }
}
