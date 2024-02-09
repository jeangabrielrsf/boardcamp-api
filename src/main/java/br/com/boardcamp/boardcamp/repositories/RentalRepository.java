package br.com.boardcamp.boardcamp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.boardcamp.boardcamp.models.RentalModel;

@Repository
public interface RentalRepository extends JpaRepository<RentalModel, Long>{
    Optional<RentalModel> findByCustomerId(Long customerId);
}
