package com.restaurant.controller.endPoint;

import com.restaurant.entity.Restaurant;
import com.restaurant.service.interfaces.RestaurantInterface;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/restaurant/1.0/")
public class RestaurantEndPoint {
    private final RestaurantInterface restaurantInterface;
    @PostMapping("add")
    public Map<String, Restaurant> addRestaurant(@RequestBody Restaurant restaurant){
        return restaurantInterface.addRestaurant(restaurant);
    }

    @GetMapping("get-all")
    public List<Restaurant> getAllRestaurant(){
        return restaurantInterface.getAllRestaurant();
    }
}
