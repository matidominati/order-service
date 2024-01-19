package com.matidominati.orderservice.orderservice.model.entity;

import com.matidominati.orderservice.orderservice.model.Customer;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Document
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

    @Id
    private Long orderId;
    private BigDecimal totalPrice;
    private List<OrderItemEntity> orderItems;
    private LocalDateTime createdAt;
    private Customer customer;
}
