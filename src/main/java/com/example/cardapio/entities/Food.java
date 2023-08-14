package com.example.cardapio.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "food")
@Entity(name = "food")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo")
    private String title;
    @Column(name = "imagem")
    private String image;
    @Column(name = "preco")
    private int price;

    public Food (FoodRequestDTO foodRequestDTO){
        this.title = foodRequestDTO.title();
        this.image = foodRequestDTO.image();
        this.price = foodRequestDTO.price();
    }

}
