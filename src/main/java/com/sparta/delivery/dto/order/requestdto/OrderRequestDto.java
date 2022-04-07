package com.sparta.delivery.dto.order.requestdto;

import com.sparta.delivery.dto.order.requestdto.FoodOrderRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class OrderRequestDto {
    private Long restaurantId;
    private List<FoodOrderRequestDto> foods;
}
