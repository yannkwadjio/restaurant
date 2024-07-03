package com.restaurant.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "restaurant")
@Entity
public class Restaurant {
    @Id
    @GeneratedValue
    private int id;
    private String nom;
    private String adresse;
    private String numeroTelephone;
    private LocalTime heuresOuverture;
    private LocalTime heuresFermeture;
}
