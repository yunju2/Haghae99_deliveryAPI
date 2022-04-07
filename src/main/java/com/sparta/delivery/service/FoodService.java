
package com.sparta.delivery.service;

import com.sparta.delivery.dto.FoodDto;
import com.sparta.delivery.exception.RestaurantNotFoundException;
import com.sparta.delivery.model.Food;
import com.sparta.delivery.model.Restaurant;
import com.sparta.delivery.repository.FoodRepository;
import com.sparta.delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;
    private final RestaurantRepository restaurantRepository;

    //음식점 메뉴판 조회
   @Transactional
    public List<FoodDto> getAllFoods(Long restaurantId) {

       Restaurant foundRestaurant = restaurantRepository.findById(restaurantId)
               .orElseThrow(() -> new IllegalArgumentException("음식점이 없습니다."));

       List<FoodDto> foodLists = new ArrayList<>();
       List<Food> getfood = foodRepository.findAllByRestaurantId(restaurantId);

       for (Food food : getfood) {
           FoodDto foodList = new FoodDto(food.getId(), food.getName(), food.getPrice());
           foodLists.add(foodList);
       }
       return foodLists;
   }

//음식점에 음식추가하기
    @Transactional
    public void addRestaurantFood(Long restaurantId, List<FoodDto> foodDto){

     //음식점 가져오기
        Optional<Restaurant> getOneRestaurant = restaurantRepository.findById(restaurantId);
        if(getOneRestaurant.isPresent()){
            Restaurant restaurant = getOneRestaurant.get();
        }else{
            throw new NullPointerException("음식점이 존재하지 않습니다.");
        }
        Restaurant restaurant = getOneRestaurant.get();

        /*Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(
                ()->new NullPointerException("해당 점포가 존재하지 않습니다.")
        );*/

   // 음식 가져오기
        for(FoodDto food : foodDto) {
            if (foodRepository.existsByNameAndRestaurant(food.getName(), restaurant)) {
                throw new NullPointerException("음식이 존재하지 않습니다.");
            } else if (food.getPrice() % 100 != 0) {
                throw new NullPointerException("100원단위로 입력하세요");
            } else if (food.getPrice() < 100 || food.getPrice() > 1000000) {
                throw new NullPointerException("입력범위 100원~1,000,000원입니다.");
            }

            Food foodList = new Food(restaurant,food);
            foodRepository.save(foodList);
        }






    }


}
