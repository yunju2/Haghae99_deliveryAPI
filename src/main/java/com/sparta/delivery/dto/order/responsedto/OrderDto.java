package com.sparta.delivery.dto.order.responsedto;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class OrderDto {
    private String restaurantName;
    private List<FoodOrderDto> foods;
    private int deliveryFee;
    private int totalPrice;

}
