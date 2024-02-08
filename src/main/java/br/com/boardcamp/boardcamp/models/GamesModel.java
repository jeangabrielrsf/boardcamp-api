package br.com.boardcamp.boardcamp.models;

import br.com.boardcamp.boardcamp.dtos.GamesDTO;
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
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "games")
public class GamesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private Integer stockTotal;

    @Column(nullable = false)
    private Integer pricePerDay;

    public GamesModel(GamesDTO gamesDTO) {
        this.name = gamesDTO.getName();
        this.image = gamesDTO.getImage();
        this.stockTotal = gamesDTO.getStockTotal();
        this.pricePerDay = gamesDTO.getPricePerDay();
    }
}
