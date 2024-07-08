package com.restaurant.controller.endPoint;

import com.restaurant.service.interfaces.UtilisateurInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UtilisateurEndPoint {
    private final UtilisateurInterface utilisateurInterface;
}
