package br.com.boardcamp.boardcamp.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class RentalDTO {
    @NotNull(message = "gameId é obrigatório!")
    private Long gameId;

    @NotNull(message = "customerId é obrigatório!")
    private Long customerId;
    
    @Positive(message = "daysRented deve ser maior que zero!")
    @NotNull(message = "daysRented é obrigatório!")
    private Integer daysRented;
}
