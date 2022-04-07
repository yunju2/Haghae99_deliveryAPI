
package com.sparta.delivery.controller;

import com.sparta.delivery.dto.FoodDto;
import com.sparta.delivery.model.Food;
import com.sparta.delivery.model.Restaurant;
import com.sparta.delivery.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    //메뉴 가져오기
    //파라미터값 1개
   @GetMapping("/restaurant/{restaurantId}/foods")
    public List<FoodDto> getAllFoods(@PathVariable Long restaurantId){
        return foodService.getAllFoods(restaurantId);
    }


    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void addRestaurantFood(@PathVariable Long restaurantId,@RequestBody List<FoodDto> foodDto){
                foodService.addRestaurantFood(restaurantId,foodDto);
    }

}

