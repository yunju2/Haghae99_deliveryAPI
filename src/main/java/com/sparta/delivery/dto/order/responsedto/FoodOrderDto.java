package com.sparta.delivery.dto.order.responsedto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodOrderDto {
    String name;
    int quantity;
    int price;
}
