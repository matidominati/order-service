package com.matidominati.orderservice.orderservice.mapper;

import com.matidominati.orderservice.orderservice.client.model.CartDto;
import com.matidominati.orderservice.orderservice.model.dto.OrderDto;
import com.matidominati.orderservice.orderservice.model.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        uses = OrderItemMapper.class,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    @Mapping(source = "id", target = "orderId")
    OrderDto map(OrderEntity orderEntity);

    @Mapping(source = "cartItems", target = "orderItems")
    @Mapping(source = "id", target = "cartId")
    @Mapping(target = "id", ignore = true)
    OrderEntity map(CartDto cartDto);
}
