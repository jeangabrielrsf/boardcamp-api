package br.com.boardcamp.boardcamp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.boardcamp.boardcamp.dtos.CustomerDTO;
import br.com.boardcamp.boardcamp.services.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/{customerId}")
    public ResponseEntity<Object> findCostumer(@PathVariable Long customerId ) {
        return ResponseEntity.status(HttpStatus.OK).body(customerService.findCostumerById(customerId));
    }

    @PostMapping
    public ResponseEntity<Object> createCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCostumer(customerDTO));
    }
}
