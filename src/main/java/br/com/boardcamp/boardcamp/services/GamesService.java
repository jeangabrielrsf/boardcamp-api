package br.com.boardcamp.boardcamp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.boardcamp.boardcamp.dtos.GamesDTO;
import br.com.boardcamp.boardcamp.models.GamesModel;
import br.com.boardcamp.boardcamp.repositories.GamesRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class GamesService {
    final GamesRepository gamesRepository;

    public List<GamesModel> listAll() {
        return gamesRepository.findAll();
    }

    public GamesModel create(GamesDTO gamesDTO) {
        if (gamesRepository.existsByName(gamesDTO.getName())) {
            
        }
        GamesModel game = new GamesModel(gamesDTO);
        return gamesRepository.save(game);
    }
}
