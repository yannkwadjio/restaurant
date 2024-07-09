package com.restaurant.security;

import com.restaurant.entity.Utilisateur;
import com.restaurant.enums.Profil;
import com.restaurant.repository.UtilisateurRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
@RequiredArgsConstructor
public class DataInitCong {
    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setUsername("admin@gmail.com");
        utilisateur.setPassword(passwordEncoder.encode("admin"));
        utilisateur.setNom("admin");
        utilisateur.setPrenom("admin");
        utilisateur.setProfil(Set.of(Profil.ADMIN, Profil.USER));
        utilisateur.setActivated(true);
        utilisateurRepository.save(utilisateur);
    }
}
