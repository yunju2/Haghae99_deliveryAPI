
package com.sparta.delivery.controller;


import com.sparta.delivery.dto.RestaurantDto;
import com.sparta.delivery.model.Restaurant;
import com.sparta.delivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RestaurantController {

     private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> findAllStores(){
         //service -> repository -> DB
         return restaurantService.findAllStores();
     }

@PostMapping("/restaurant/register")
    public Restaurant saveRestaurant(@RequestBody RestaurantDto restaurantDto) {
        return restaurantService.addRestaurant(restaurantDto);

}


}

