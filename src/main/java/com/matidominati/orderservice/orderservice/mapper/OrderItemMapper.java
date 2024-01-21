package com.matidominati.orderservice.orderservice.mapper;

import com.matidominati.orderservice.orderservice.client.model.CartItemDto;
import com.matidominati.orderservice.orderservice.model.dto.OrderItemDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderItemMapper {

    @Mapping(source = "id", target = "productId")
    OrderItemDto map(CartItemDto cartItemDto);
}
