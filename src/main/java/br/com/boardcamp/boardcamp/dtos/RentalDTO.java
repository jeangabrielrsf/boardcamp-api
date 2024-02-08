package br.com.boardcamp.boardcamp.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class RentalDTO {
    @NotBlank(message = "gameId é obrigatório!")
    private Long gameId;
    
    @NotBlank(message = "customerId é obrigatório!")
    private Long customerId;
    
    @Positive(message = "daysRented deve ser maior que zero!")
    @NotBlank(message = "daysRented é obrigatório!")
    private Integer daysRented;
}
