package com.restaurant.service.interfaces;

import com.restaurant.entity.Utilisateur;
import org.springframework.http.ResponseEntity;

import java.util.Map;
import java.util.UUID;

public interface UtilisateurInterface {
    Map<String, String> createUtilisateur(Utilisateur utilisateur);

    Map<String,String> getActivationCode(UUID activationCode);
}
