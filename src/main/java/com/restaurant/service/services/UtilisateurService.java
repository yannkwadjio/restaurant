package com.restaurant.service.services;

import com.restaurant.repository.UtilisateurRepository;
import com.restaurant.service.interfaces.UtilisateurInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UtilisateurService implements UtilisateurInterface {
private final UtilisateurRepository utilisateurRepository;
}
