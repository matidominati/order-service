package com.matidominati.orderservice.orderservice.service;

import com.matidominati.orderservice.orderservice.client.CartClient;
import com.matidominati.orderservice.orderservice.model.dto.OrderDto;
import com.matidominati.orderservice.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private CartClient cartClient;

    public OrderDto getById(Long id) {

    }

}
