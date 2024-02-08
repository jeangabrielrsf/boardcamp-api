package br.com.boardcamp.boardcamp.models;

import java.time.LocalDate;

import br.com.boardcamp.boardcamp.dtos.RentalDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rentals")
public class RentalModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private LocalDate rentDate;

    private Integer daysRented;

    @Column(nullable = true)
    private LocalDate returnDate;

    @Column(nullable = false)
    private Integer originalPrice;

    private Integer delayFee;

    @OneToOne
    @JoinColumn(name = "game_id")
    private GamesModel game;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private CustomerModel customer;



    public RentalModel(RentalDTO rentalDTO) {
        this.daysRented = rentalDTO.getDaysRented();
    }
}
