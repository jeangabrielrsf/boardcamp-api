package br.com.boardcamp.boardcamp.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class GamesDTO {
    @NotBlank(message = "Nome não pode ser vazio!")
    private String name;

    @NotBlank(message = "URL de imagem inválida!")
    private String image;

    @NotNull(message = "Número de jogos no estoque não pode ser nulo!")
    @Positive(message = "Número de jogos no estoque precisa ser maior que zero!")
    private Integer stockTotal;

    @NotNull(message = "Preço diário de um jogo não pode ser nulo!")
    @Positive(message = "Preço diário de um jogo precisa ser maior que zero!")
    private Integer pricePerDay;
}
