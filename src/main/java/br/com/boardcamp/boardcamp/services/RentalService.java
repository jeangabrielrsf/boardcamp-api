package br.com.boardcamp.boardcamp.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.boardcamp.boardcamp.dtos.RentalDTO;
import br.com.boardcamp.boardcamp.exceptions.GameStockInsuficientException;
import br.com.boardcamp.boardcamp.exceptions.RentalAlreadyFinished;
import br.com.boardcamp.boardcamp.exceptions.RentalNotFinishedException;
import br.com.boardcamp.boardcamp.exceptions.RentalNotFoundException;
import br.com.boardcamp.boardcamp.models.CustomerModel;
import br.com.boardcamp.boardcamp.models.GamesModel;
import br.com.boardcamp.boardcamp.models.RentalModel;
import br.com.boardcamp.boardcamp.repositories.RentalRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RentalService {
    private final RentalRepository rentalRepository;
    private final GamesService gamesService;
    private final CustomerService customerService;
    
    public List<RentalModel> findAllRentals() {
        return rentalRepository.findAll();
    }

    public RentalModel createRental(RentalDTO rentalDTO) {
        GamesModel game = gamesService.findGameById(rentalDTO.getGameId());
        CustomerModel customer = customerService.findCostumerById(rentalDTO.getCustomerId());
        Optional<RentalModel> checkRental = rentalRepository.findByCustomerId(customer.getId());
        if (checkRental.isPresent() && checkRental.get().getReturnDate() == null) {
            throw new RentalNotFinishedException("Cliente está com um aluguel em andamento!");
        }

        if (game.getStockTotal() == 0) {
            throw new GameStockInsuficientException("Estoque do jogo é insuficiente para alugar!");
        }
        RentalModel rental =  new RentalModel(rentalDTO, customer, game);
        gamesService.decreaseGameStock(game.getId());
        return rentalRepository.save(rental);
    }

    public RentalModel finishRental(Long rentalId) {
        RentalModel rental = rentalRepository.findById(rentalId)
            .orElseThrow(()-> new RentalNotFoundException("Aluguel não encontrado!"));
    
        if (rental.getReturnDate() != null) {
            throw new RentalAlreadyFinished("Aluguel já foi finalizado!");
        }
        
        rental.setReturnDate(LocalDate.now());
        
        LocalDate finalDate = rental.getRentDate().plusDays(rental.getDaysRented());
        
        if(rental.getReturnDate().isAfter(finalDate) ) {
            long daysDiff = ChronoUnit.DAYS.between(finalDate, rental.getReturnDate());
            rental.setDelayFee((int)(daysDiff * rental.getGame().getPricePerDay()));
        }
        return rentalRepository.save(rental);
    }
}
