
package com.sparta.delivery.model;


import com.sparta.delivery.dto.RestaurantDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity(name = "restaurant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    //대표값 선정
    @GeneratedValue(strategy = GenerationType.IDENTITY) //번호 자동 생성 //자동으로 새로운 레코드가 생성이 될때마다 마지막 PK 값에서 자동으로 +1 을 해주는 방식
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private int minOrderPrice;

    @Column
    private int deliveryFee;

    //해당 음식점에 속한 메뉴들


    public Restaurant(RestaurantDto restaurantDto) {
        this.name = restaurantDto.getName();
        this.minOrderPrice =restaurantDto.getMinOrderPrice();
        this.deliveryFee = restaurantDto.getDeliveryFee();
    }
}

