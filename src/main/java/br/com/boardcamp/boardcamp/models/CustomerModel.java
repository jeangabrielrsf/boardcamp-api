package br.com.boardcamp.boardcamp.models;

import br.com.boardcamp.boardcamp.dtos.CustomerDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class CustomerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 11, nullable = false)
    private String cpf;

    public CustomerModel(CustomerDTO customerDTO) {
        this.name = customerDTO.getName();
        this.cpf = customerDTO.getCpf();
    }
}
