package br.com.boardcamp.boardcamp.exceptions;

public class GameAlreadyExistsException extends RuntimeException {
    GameAlreadyExistsException(String message) {
        super(message);
    }
}
