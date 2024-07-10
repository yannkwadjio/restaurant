package com.restaurant.repository;

import com.restaurant.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
Utilisateur findByUsername(String username);
Optional<Utilisateur> findByActivationCode(UUID activationCode);
}
