package com.matidominati.orderservice.orderservice.mapper;

import com.matidominati.orderservice.orderservice.client.model.CartDto;
import com.matidominati.orderservice.orderservice.model.dto.OrderDto;
import com.matidominati.orderservice.orderservice.model.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    OrderDto map(OrderEntity orderEntity);
    OrderDto map(CartDto cartDto);
}
