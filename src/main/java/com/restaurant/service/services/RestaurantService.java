package com.restaurant.service.services;

import com.restaurant.entity.Restaurant;
import com.restaurant.repository.RestaurantRepository;
import com.restaurant.service.interfaces.RestaurantInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RestaurantService implements RestaurantInterface {
    private final RestaurantRepository restaurantRepository;

    @Override
    public Map<String, String> addRestaurant(Restaurant restaurant) {
       Map<String,String> resultat=new HashMap<>();
       Optional<Restaurant> existingRestaurant=restaurantRepository.findByNom(restaurant.getNom());
        if(existingRestaurant.isPresent()){
            resultat.put("message","Restaurant existant");
        }else{
            //restaurantRepository.save(restaurant);
            resultat.put("message",restaurantRepository.save(restaurant).toString());
        }

        return resultat;
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }
}
