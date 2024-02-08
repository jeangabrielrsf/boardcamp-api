package br.com.boardcamp.boardcamp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.boardcamp.boardcamp.models.RentalModel;
import br.com.boardcamp.boardcamp.repositories.RentalRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RentalService {
    private final RentalRepository rentalRepository;
    
    public List<RentalModel> findAllRentals() {
        return rentalRepository.findAll();
    }
}
