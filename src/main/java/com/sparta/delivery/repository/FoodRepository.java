
package com.sparta.delivery.repository;

import com.sparta.delivery.dto.FoodDto;
import com.sparta.delivery.model.Food;
import com.sparta.delivery.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface FoodRepository extends JpaRepository<Food,Long> {
   List<Food> findAllByRestaurantId(Long restaurant_id);

   boolean existsByNameAndRestaurant(String foodname, Restaurant restaurant);
}

