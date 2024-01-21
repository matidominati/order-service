package com.matidominati.orderservice.orderservice.repository;

import com.matidominati.orderservice.orderservice.model.entity.OrderEntity;
import com.matidominati.orderservice.orderservice.model.enums.OrderStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OrderRepository extends MongoRepository<OrderEntity, String> {
    Optional<OrderEntity> findByOrderStatus(OrderStatus orderStatus);
}
