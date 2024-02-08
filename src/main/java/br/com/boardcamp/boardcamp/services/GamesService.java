package br.com.boardcamp.boardcamp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.boardcamp.boardcamp.dtos.GamesDTO;
import br.com.boardcamp.boardcamp.models.GamesModel;
import br.com.boardcamp.boardcamp.repositories.GamesRepository;
import lombok.AllArgsConstructor;
import br.com.boardcamp.boardcamp.exceptions.GameAlreadyExistsException;
import br.com.boardcamp.boardcamp.exceptions.GameNotFoundException;

@AllArgsConstructor
@Service
public class GamesService {
    final GamesRepository gamesRepository;

    public List<GamesModel> listAll() {
        return gamesRepository.findAll();
    }

    public GamesModel create(GamesDTO gamesDTO) {
        if (gamesRepository.existsByName(gamesDTO.getName())) throw new GameAlreadyExistsException("Já existe um jogo com esse nome!");
        GamesModel game = new GamesModel(gamesDTO);
        return gamesRepository.save(game);
    }

    public GamesModel findGameById(Long gameId) {
        return gamesRepository.findById(gameId)
            .orElseThrow(()-> new GameNotFoundException("Jogo não encontrado!"));
    }
}