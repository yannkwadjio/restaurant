package com.restaurant.entity;

import com.restaurant.enums.Profil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "utilisateur")
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    private String password;
    private String passwordConfirmation;
    private UUID passwordCodeReset;
    private UUID activationCode;
    private Set<Profil> profil;
    @Column(unique = true)
    private String username;
    private boolean isActivated;
}
