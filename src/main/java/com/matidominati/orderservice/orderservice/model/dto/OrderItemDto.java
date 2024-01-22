package com.matidominati.orderservice.orderservice.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDto {

    private Long productId;
    private String productName;
    private BigDecimal price;
}
