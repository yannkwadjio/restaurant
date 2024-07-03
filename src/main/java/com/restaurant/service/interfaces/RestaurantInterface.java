package com.restaurant.service.interfaces;

import com.restaurant.entity.Restaurant;

import java.util.List;
import java.util.Map;

public interface RestaurantInterface {
    Map<String, Restaurant> addRestaurant(Restaurant restaurant);

    List<Restaurant> getAllRestaurant();
}
