package com.sparta.delivery.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String restaurantName;

    @Column
    private int totalPrice;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "OrderRequest_id")
    private List<OrderRequest> foods;

}
