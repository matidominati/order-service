package com.matidominati.orderservice.orderservice.repository;

import com.matidominati.orderservice.orderservice.model.entity.OrderEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderEntity, Long> {
}
