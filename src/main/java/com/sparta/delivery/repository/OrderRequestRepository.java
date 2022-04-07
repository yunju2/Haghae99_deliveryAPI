package com.sparta.delivery.repository;

import com.sparta.delivery.model.OrderRequest;
import com.sparta.delivery.model.Orders;
import com.sparta.delivery.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRequestRepository extends JpaRepository<OrderRequest,Long> {
}
