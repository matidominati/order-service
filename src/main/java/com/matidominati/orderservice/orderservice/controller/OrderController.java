package com.matidominati.orderservice.orderservice.controller;

import com.matidominati.orderservice.orderservice.model.Customer;
import com.matidominati.orderservice.orderservice.model.dto.OrderDto;
import com.matidominati.orderservice.orderservice.model.entity.OrderEntity;
import com.matidominati.orderservice.orderservice.model.enums.OrderStatus;
import com.matidominati.orderservice.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderDto> getOrders(@RequestParam(required = false) OrderStatus status) {
        return orderService.getAll(status);
    }

    @GetMapping("/{id}")
    public OrderDto getById(@PathVariable String id) {
        return orderService.getById(id);
    }

    @PostMapping("/{cartId}")
    public OrderDto create(@PathVariable Long cartId, @RequestBody Customer customerDetails) {
        return orderService.create(cartId, customerDetails);
    }

    @PatchMapping("/{id}")
    public OrderStatus confirm(@PathVariable String id) {
        return orderService.confirm(id);
    }

    @PatchMapping("/modify/{id}")
    public OrderDto modify(@PathVariable String id, OrderEntity updatedOrder) {
        return orderService.modifyCustomerData(id, updatedOrder);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        orderService.delete(id);
    }

}
