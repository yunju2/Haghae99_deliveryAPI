
package com.sparta.delivery.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class RestaurantDto {
        private Long id;
        private String name;
        private int MinOrderPrice;
        private int DeliveryFee;

}

