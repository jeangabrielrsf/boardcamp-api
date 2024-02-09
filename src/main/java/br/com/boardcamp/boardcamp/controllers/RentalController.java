package br.com.boardcamp.boardcamp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.boardcamp.boardcamp.dtos.RentalDTO;
import br.com.boardcamp.boardcamp.services.RentalService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/rentals")
public class RentalController {
    private final RentalService rentalService;

    @GetMapping
    public ResponseEntity<Object> listRentals() {
        return ResponseEntity.status(HttpStatus.OK).body(rentalService.findAllRentals());
    }

    @PostMapping
    public ResponseEntity<Object> createRental(@RequestBody @Valid RentalDTO rentalDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(rentalService.createRental(rentalDTO));
    }

    @PutMapping("/{rentalId}/return")
    public ResponseEntity<Object> finishRental(@PathVariable Long rentalId) {
        return ResponseEntity.status(HttpStatus.OK).body(rentalService.finishRental(rentalId));
    }
}
