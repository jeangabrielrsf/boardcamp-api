package br.com.boardcamp.boardcamp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.boardcamp.boardcamp.services.RentalService;
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
}
