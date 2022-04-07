package com.sparta.delivery.exception;

public class RestaurantNotFoundException extends Exception {
    private Long restaurant_id;

    public RestaurantNotFoundException(Long restaurant_id){
        super(String.format("음식점을 찾을 수 없습니다.id ='%s'",restaurant_id));
    }

}
