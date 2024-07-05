package com.restaurant.service.interfaces;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface ImageRestaurantInterface {
    Map<String, String> addImgRestaurant(MultipartFile file,int idRestaurant);
}
