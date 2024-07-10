package com.restaurant.controller.endPoint;

import com.restaurant.entity.Utilisateur;
import com.restaurant.service.interfaces.UtilisateurInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/myrestaurant/1/user/")
public class UtilisateurEndPoint {
    private final UtilisateurInterface utilisateurInterface;

    @PostMapping("/create")
    public Map<String,String> createUtilisateur(@RequestBody Utilisateur utilisateur) {
        return utilisateurInterface.createUtilisateur(utilisateur);
    }

    @GetMapping("/{activationCode}")
    public Map<String,String> getActivationCode(@PathVariable("activationCode") UUID activationCode) {
        return utilisateurInterface.getActivationCode(activationCode);
    }
}
