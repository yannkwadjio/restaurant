package com.restaurant.service.interfaces;

import com.restaurant.entity.Utilisateur;

import java.util.Map;

public interface UtilisateurInterface {
    Map<String, String> createUtilisateur(Utilisateur utilisateur);
}
