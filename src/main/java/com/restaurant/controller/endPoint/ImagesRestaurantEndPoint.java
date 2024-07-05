package com.restaurant.controller.endPoint;

import com.restaurant.service.interfaces.ImageRestaurantInterface;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/restaurant/v1/")
@AllArgsConstructor
public class ImagesRestaurantEndPoint {
    private final ImageRestaurantInterface imageRestaurantInterface;
    @PostMapping("/addImage")
    public Map<String,String> addImgRestaurant(MultipartFile file,int idRestaurant){

        return imageRestaurantInterface.addImgRestaurant(file,idRestaurant);
    }
}
