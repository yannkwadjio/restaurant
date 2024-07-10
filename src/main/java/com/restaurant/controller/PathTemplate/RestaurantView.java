package com.restaurant.controller.PathTemplate;

import com.restaurant.entity.ImagesRestaurant;
import com.restaurant.entity.Restaurant;
import com.restaurant.entity.Utilisateur;
import com.restaurant.service.services.EmailService;
import com.restaurant.service.services.ImageRestaurantService;
import com.restaurant.service.services.RestaurantService;
import com.restaurant.service.services.UtilisateurService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Controller
@AllArgsConstructor
public class RestaurantView {
    private final RestaurantService restaurantService;
    private final ImageRestaurantService imageRestaurantService;


    @GetMapping("/login")
    public String getPageLogin(Model model) {
        model.addAttribute("listRestaurant", restaurantService.getAllRestaurant());
        return "login";
    }

    @PostMapping("/login")
    public String PageLogin(Model model) {
        return "redirect:/home";
    }


    @PostMapping("/logout")
    public String PostPageLogout(Model model) {
        return "redirect:/login";
    }



    @GetMapping("/home")
    public String getPageAccueil(Model model) {
        model.addAttribute("listRestaurant", restaurantService.getAllRestaurant());
        return "home";
    }


    @GetMapping("/create")
    public String getPageCreate(Model model) {
        Restaurant restaurant = new Restaurant();
        model.addAttribute("restaurant", restaurant);
        model.addAttribute("message","Compte créé");
        return "creation";
    }

    @PostMapping("/create")
    public String PageCreate(Model model, @ModelAttribute Restaurant restaurant) {
        Map<String,String> response=restaurantService.addRestaurant(restaurant);
        model.addAttribute("messageReponse",response.get("message"));
        return "redirect:home";
    }



    @PostMapping("/delete/{id}")
    public String PageDelete(Model model,@PathVariable("id") int id){
        model.addAttribute("id",id);
        restaurantService.deleteRetaurantById(id);
        return "redirect:/home";
    }

    @PostMapping("/upload/{idRestaurant}")
    public String PageUpload(@PathVariable("idRestaurant") int idRestaurant, @RequestParam("file") MultipartFile file,Model model){
        model.addAttribute("idRestaurant",idRestaurant);
        ImagesRestaurant imagesRestaurant=new ImagesRestaurant();
        imagesRestaurant.setIdRestaurant(idRestaurant);
        imagesRestaurant.setTypeImage(file.getContentType());
        imagesRestaurant.setTitreImage(file.getOriginalFilename());
        imageRestaurantService.addImgRestaurant(file,idRestaurant);
        return "redirect:/home";
    }



}




