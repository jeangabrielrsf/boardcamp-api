package br.com.boardcamp.boardcamp.exceptions;

public class GameStockInsuficientException extends RuntimeException{
    public GameStockInsuficientException(String message) {
        super(message);
    }
}
