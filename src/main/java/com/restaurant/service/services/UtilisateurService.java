package com.restaurant.service.services;

import com.restaurant.entity.Utilisateur;
import com.restaurant.enums.Profil;
import com.restaurant.repository.UtilisateurRepository;
import com.restaurant.service.interfaces.UtilisateurInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UtilisateurService implements UtilisateurInterface {
private final UtilisateurRepository utilisateurRepository;
private final PasswordEncoder passwordEncoder;

    @Override
    public Map<String, String> createUtilisateur(Utilisateur utilisateur) {
        Map<String,String> response=new HashMap<>();

if(utilisateur.getPassword().equals(utilisateur.getPasswordConfirmation())){
    utilisateur.setActivated(false);
    utilisateur.setPassword(passwordEncoder.encode(utilisateur.getPassword()));
    utilisateur.setProfil(Set.of(Profil.USER));
    utilisateur.setActivationCode(UUID.randomUUID());
    utilisateurRepository.save(utilisateur);
    response.put("message","Utilisateur Créé");
}else{
    response.put("message","Mots de passe non identiques");
}
        return response;
    }

    @Override
    public Map<String, String> getActivationCode(UUID activationCode) {
        Map<String,String> response=new HashMap<>();
        Optional<Utilisateur> utilisateur=utilisateurRepository.findByActivationCode(activationCode);

        if(utilisateur.isPresent()){
utilisateur.get().setActivated(true);
 utilisateur.get().setActivationCode(null);
            utilisateurRepository.save(utilisateur.get());
        }
        return response;
    }


}
