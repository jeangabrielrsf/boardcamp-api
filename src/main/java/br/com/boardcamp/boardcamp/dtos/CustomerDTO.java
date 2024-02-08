package br.com.boardcamp.boardcamp.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDTO {
    @NotBlank(message = "Nome de cliente não pode ser vazio!")
    private String name;

    @NotBlank(message = "CPF do cliente é obrigatório!")
    @Size(min = 11, max = 11, message = "CPF com tamanho inválido!")
    private String cpf;
}
