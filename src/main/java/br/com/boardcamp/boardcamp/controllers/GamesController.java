package br.com.boardcamp.boardcamp.controllers;




import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.boardcamp.boardcamp.dtos.GamesDTO;
import br.com.boardcamp.boardcamp.services.GamesService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/games")
public class GamesController {
    private final GamesService gamesService;

    @GetMapping
    public ResponseEntity<Object> listAllGames() {
        return ResponseEntity.status(HttpStatus.OK).body(gamesService.listAll()); 
    }

    @PostMapping
    public ResponseEntity<Object> createGame(@RequestBody @Valid GamesDTO gamesDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gamesService.create(gamesDTO));
    }
}
