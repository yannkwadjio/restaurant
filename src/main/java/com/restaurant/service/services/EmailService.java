package com.restaurant.service.services;

import com.restaurant.entity.Utilisateur;
import com.restaurant.service.interfaces.EmailInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService implements EmailInterface {
   private final JavaMailSender mailSender;

    public void sendEmail(Utilisateur utilisateur) {
       String activationLink="http://localhost:8080/activation/"+ utilisateur.getActivationCode();
       SimpleMailMessage message=new SimpleMailMessage();
       message.setTo(utilisateur.getUsername());
       message.setSubject("Activation du compte");
       message.setText("Veuillez cliquer pour activer votre compte utilisateur: "+activationLink);
       message.setFrom("kwadjionry@gmail.com");
       mailSender.send(message);
    }
    public void sendEmailPassword(Utilisateur utilisateur) {
        String resetLink="http://localhost:8080/reset-password/"+ utilisateur.getPasswordCodeReset();
        SimpleMailMessage message=new SimpleMailMessage();
        message.setTo(utilisateur.getUsername());
        message.setSubject("Réinitialisation mot de asse");
        message.setText("Veuillez cliquer pour réinitialiser le mont de passe: "+resetLink);
        message.setFrom("kwadjionry@gmail.com");
        mailSender.send(message);
    }

}
