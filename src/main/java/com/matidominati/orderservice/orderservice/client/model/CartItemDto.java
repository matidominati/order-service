package com.matidominati.orderservice.orderservice.client.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItemDto {
    private Long id;
    private String productName;
    private String productType;
    private String productDescription;
    private BigDecimal price;
}
