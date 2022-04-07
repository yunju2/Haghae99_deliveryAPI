
package com.sparta.delivery.service;

import com.sparta.delivery.dto.RestaurantDto;
import com.sparta.delivery.model.Restaurant;
import com.sparta.delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository; //find 사용

    public List<Restaurant> findAllStores(){
        return restaurantRepository.findAll();
    }

    public Restaurant addRestaurant(RestaurantDto restaurantDto){

        Restaurant store = new Restaurant(restaurantDto);

        int deliveryfee = restaurantDto.getDeliveryFee();

        if(deliveryfee % 500 !=0  ){
                throw new NullPointerException("500원단위로 입력하세요");
        }else if(deliveryfee<0 ||  deliveryfee >10000){
            throw new NullPointerException("1000원 이상 10,000이하 단위로 입력하세요");
        }
        int minoderprice = restaurantDto.getMinOrderPrice();

        if(minoderprice % 100 !=0){
            throw new NullPointerException("100단위로 입력하세요");
        } else if(minoderprice<1000||minoderprice>100000){
            throw new NullPointerException("100,000이하로 입력하세요.");
        }


    return restaurantRepository.save(store);

    }
}
