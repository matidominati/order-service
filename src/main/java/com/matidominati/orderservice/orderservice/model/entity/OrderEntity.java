package com.matidominati.orderservice.orderservice.model.entity;

import com.matidominati.orderservice.orderservice.model.Customer;
import com.matidominati.orderservice.orderservice.model.dto.OrderItemDto;
import com.matidominati.orderservice.orderservice.model.enums.OrderStatus;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Document
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

    @Id
    private String id;
    private Long cartId;
    private BigDecimal totalPrice;
    private List<OrderItemDto> orderItems;
    private LocalDateTime createdAt;
    private Customer customer;
    private OrderStatus orderStatus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity order = (OrderEntity) o;
        return id != null && Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }
}

