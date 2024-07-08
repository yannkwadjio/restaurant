package com.restaurant.security;

import com.restaurant.entity.Utilisateur;
import com.restaurant.enums.Profil;
import com.restaurant.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UtilisateurDetailService implements UserDetailsService {
private final UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur utilisateur=utilisateurRepository.findByUsername(username);
        if(utilisateur==null){
            throw new UsernameNotFoundException("Utilisateur introuvable");
        }

        return new User(utilisateur.getUsername(),utilisateur.getPassword(),
                utilisateur.getProfil().stream()
                        .map(profil->new SimpleGrantedAuthority(profil.name()))
                        .collect(Collectors.toSet())
        );
    }





}
