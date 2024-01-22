package com.matidominati.orderservice.orderservice.model.dto;

import com.matidominati.orderservice.orderservice.model.Customer;
import com.matidominati.orderservice.orderservice.model.enums.OrderStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderDto {

    private String orderId;
    private Long cartId;
    private LocalDateTime createdAt;
    private OrderStatus orderStatus;
    private List<OrderItemDto> orderItems;
    private BigDecimal totalPrice;
    private Customer customer;
}
