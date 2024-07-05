package com.restaurant.controller.PathTemplate;

import com.restaurant.entity.Restaurant;
import com.restaurant.service.services.RestaurantService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
@AllArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

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
        return "redirect:home";
    }
}
