package br.com.boardcamp.boardcamp.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.boardcamp.boardcamp.dtos.CustomerDTO;
import br.com.boardcamp.boardcamp.exceptions.CustomerAlreadyExistsException;
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

    public CustomerModel createCostumer(CustomerDTO customerDTO) {
        if (customerRepository.existsByCpf(customerDTO.getCpf())) {
            throw new CustomerAlreadyExistsException("CPF já está cadastrado!");
        }
        CustomerModel customer = new CustomerModel(customerDTO);
        return customerRepository.save(customer);
    }
}
