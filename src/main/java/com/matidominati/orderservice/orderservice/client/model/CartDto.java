package com.matidominati.orderservice.orderservice.client.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class CartDto {
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private BigDecimal totalPrice;
    private List<CartItemDto> cartItemEntities;
    private String discountCode;
}
