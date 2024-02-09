package br.com.boardcamp.boardcamp.exceptions;

public class RentalNotFinishedException extends RuntimeException{
    public RentalNotFinishedException(String message) {
        super(message);
    }
}
