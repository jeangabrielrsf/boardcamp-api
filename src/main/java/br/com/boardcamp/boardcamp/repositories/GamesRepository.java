package br.com.boardcamp.boardcamp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.boardcamp.boardcamp.models.GamesModel;

@Repository
public interface GamesRepository extends JpaRepository<GamesModel, Long>{
    
}
