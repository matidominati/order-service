package com.matidominati.orderservice.orderservice.model.dto;

import com.matidominati.orderservice.orderservice.model.entity.OrderItemEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDto {

    private Long orderId;
    private BigDecimal totalPrice;
    private List<OrderItemEntity> orderItems;
    private LocalDateTime createdAt;
}
