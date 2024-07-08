package com.restaurant.repository;

import com.restaurant.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {
Utilisateur findByUsername(String username);
}
