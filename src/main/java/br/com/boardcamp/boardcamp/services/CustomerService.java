package br.com.boardcamp.boardcamp.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.boardcamp.boardcamp.exceptions.CustomerNotFoundException;
import br.com.boardcamp.boardcamp.models.CustomerModel;
import br.com.boardcamp.boardcamp.repositories.CustomerRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerModel findCostumerById(Long customerId) {
        Optional<CustomerModel> customer = customerRepository.findById(customerId);
        if (customer.isEmpty()) {
            throw new CustomerNotFoundException("Cliente não existente!");
        }
        return customer.get();
    }
}
