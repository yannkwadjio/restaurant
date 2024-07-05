package com.restaurant.service.services;

import com.restaurant.entity.ImagesRestaurant;
import com.restaurant.repository.ImageRestaurantRpository;
import com.restaurant.service.interfaces.ImageRestaurantInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class ImageRestaurantService implements ImageRestaurantInterface {
    private final ImageRestaurantRpository imageRestaurantRpository;
    private final Path path = Paths.get("src/main/resources/static/img");


    @Override
    public Map<String, String> addImgRestaurant(MultipartFile file,int idRestaurant) {
        Map<String, String> reponse = new HashMap<>();

        try {
            Files.copy(file.getInputStream(), this.path.resolve(file.getOriginalFilename()));
            ImagesRestaurant imagesRestaurant=new ImagesRestaurant();
            imagesRestaurant.setIdRestaurant(idRestaurant);
            imagesRestaurant.setTitreImage(file.getOriginalFilename());
            imagesRestaurant.setTypeImage(file.getContentType());
            imageRestaurantRpository.save(imagesRestaurant);
        } catch (Exception e) {
            e.getMessage();
        }
        return Map.of();
    }
}
