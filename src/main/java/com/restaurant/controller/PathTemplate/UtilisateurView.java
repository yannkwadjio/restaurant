package com.restaurant.controller.PathTemplate;

import com.restaurant.entity.Utilisateur;
import com.restaurant.service.services.EmailService;
import com.restaurant.service.services.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class UtilisateurView {
    private final UtilisateurService utilisateurService;
    private final EmailService emailService;

    @GetMapping("/register")
    public String getPageRegister(Model model, @ModelAttribute Utilisateur utilisateur) {
        model.addAttribute("utilisateur", utilisateur);
        return "register";
    }

    @PostMapping("/register")
    public String PageRegister(Model model, @ModelAttribute Utilisateur utilisateur) {
        Map<String, String> reponse = utilisateurService.createUtilisateur(utilisateur);
        emailService.sendEmail(utilisateur);
        return "redirect:/activation";
    }

    @GetMapping("/reset-password")
    public String getPageResetPassword(Model model) {
        return "reset_password";
    }

    @GetMapping("/activation")
    public String getPageActivation(Model model) {
        return "activation";
    }

}
