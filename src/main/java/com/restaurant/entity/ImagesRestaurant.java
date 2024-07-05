package com.restaurant.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Table(name = "imagesResto")
@Entity
public class ImagesRestaurant {
    @Id
    @GeneratedValue
    private int id;
    private String titreImage;
    private String typeImage;
    private int idRestaurant;
}
