
package com.sparta.delivery.model;

import com.sparta.delivery.dto.FoodDto;
import com.sparta.delivery.dto.RestaurantDto;
import com.sparta.delivery.repository.FoodRepository;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity(name = "food")
@NoArgsConstructor
@AllArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int price;

@ManyToOne
@JoinColumn(name="restaurant_id")
private Restaurant restaurant;


    public Food(Restaurant restaurant, FoodDto foodDto){

        this.restaurant = restaurant;
        this.name = foodDto.getName();
        this.price = foodDto.getPrice();
    }
}

