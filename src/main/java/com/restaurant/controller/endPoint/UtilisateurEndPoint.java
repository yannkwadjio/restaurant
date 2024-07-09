package com.restaurant.controller.endPoint;

import com.restaurant.entity.Utilisateur;
import com.restaurant.service.interfaces.UtilisateurInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UtilisateurEndPoint {
    private final UtilisateurInterface utilisateurInterface;

    @PostMapping("/user")
    public Map<String,String> createUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurInterface.createUtilisateur(utilisateur);
    }
}
