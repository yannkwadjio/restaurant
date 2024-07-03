package com.restaurant.service.services;

import com.restaurant.entity.Restaurant;
import com.restaurant.repository.RestaurantRepository;
import com.restaurant.service.interfaces.RestaurantInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class RestaurantService implements RestaurantInterface {
    private final RestaurantRepository restaurantRepository;

    @Override
    public Map<String, Restaurant> addRestaurant(Restaurant restaurant) {
       Map<String,Restaurant> resultat=new HashMap<>();
        resultat.put("message",restaurantRepository.save(restaurant));
        return resultat;
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }
}
