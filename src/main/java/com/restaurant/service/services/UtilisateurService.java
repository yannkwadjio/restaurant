package com.restaurant.service.services;

import com.restaurant.entity.Utilisateur;
import com.restaurant.enums.Profil;
import com.restaurant.repository.UtilisateurRepository;
import com.restaurant.service.interfaces.UtilisateurInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UtilisateurService implements UtilisateurInterface {
private final UtilisateurRepository utilisateurRepository;

    @Override
    public Map<String, String> createUtilisateur(Utilisateur utilisateur) {
        Map<String,String> response=new HashMap<>();
        utilisateur.setActivated(false);
        utilisateur.setProfil(Set.of(Profil.USER));
       if(utilisateur.getPassword().equals(utilisateur.getPasswordConfirmation())){
           utilisateurRepository.save(utilisateur);
           response.put("message","Utilisateur Créé");
       }else{
           response.put("message","Les 2 mots de passe ne sont pas identiques");
       }

        return response;
    }
}
