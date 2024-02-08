package br.com.boardcamp.boardcamp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.boardcamp.boardcamp.models.CustomerModel;
import br.com.boardcamp.boardcamp.services.CustomerService;
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
}
