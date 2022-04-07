package com.sparta.delivery.dto.order.requestdto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FoodOrderRequestDto {
    Long id;
    int quantity;

}
