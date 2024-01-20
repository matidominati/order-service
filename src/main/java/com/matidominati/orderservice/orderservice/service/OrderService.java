package com.matidominati.orderservice.orderservice.service;

import com.matidominati.orderservice.orderservice.client.CartClient;
import com.matidominati.orderservice.orderservice.client.model.CartDto;
import com.matidominati.orderservice.orderservice.mapper.OrderMapper;
import com.matidominati.orderservice.orderservice.model.dto.OrderDto;
import com.matidominati.orderservice.orderservice.model.entity.OrderEntity;
import com.matidominati.orderservice.orderservice.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.matidominati.orderservice.orderservice.utils.RepositoryUtils.findByIdOrThrow;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private CartClient cartClient;
    private final OrderMapper mapper;

    public OrderDto getById(Long id) {
        log.info("Search process for order with ID: {} has started", id);
        OrderEntity order = findByIdOrThrow(id, orderRepository, OrderEntity.class);
        log.info("Order with ID: {} found", id);
        return mapper.map(order);
    }

    public List<OrderDto> getAll() {
        log.info("Search process for all products has started");
        List<OrderDto> orders = orderRepository.findAll().stream()
                .map(mapper::map)
                .toList();
        log.info("{} orders found", orders.size());
        return orders;
    }

    @Transactional
    public OrderDto create(Long cartId, OrderEntity order) {
        log.info("Creating order from cart with ID: {}", cartId);
        OrderDto orderDto = mapper.map(cartClient.getCart(cartId));
        log.info("Mapping cart to order DTO: {}", orderDto);
        OrderEntity newOrder = new OrderEntity();
        newOrder.setCreatedAt(order.getCreatedAt());
        newOrder.setCustomer(order.getCustomer());
        newOrder.setTotalPrice(orderDto.getTotalPrice());
        newOrder.setOrderItems(orderDto.getOrderItems());
        log.info("Saving new order: {}", newOrder);
        orderRepository.save(newOrder);
        log.info("Order created successfully. New order details: {}", newOrder);
        return mapper.map(newOrder);
    }

    @Transactional
    public OrderDto modifyCustomerData(Long id, OrderEntity updatedOrder) {
        OrderEntity order = findByIdOrThrow(id, orderRepository, OrderEntity.class);
        order.setCustomer(updatedOrder.getCustomer());
        return mapper.map(order);
    }

    @Transactional
    public void delete(Long id) {
        OrderEntity order = findByIdOrThrow(id, orderRepository, OrderEntity.class);
        orderRepository.delete(order);
    }

}
