package com.matidominati.orderservice.orderservice.service;

import com.matidominati.orderservice.orderservice.client.CartClient;
import com.matidominati.orderservice.orderservice.exception.OrderModificationException;
import com.matidominati.orderservice.orderservice.mapper.OrderMapper;
import com.matidominati.orderservice.orderservice.model.Customer;
import com.matidominati.orderservice.orderservice.model.dto.OrderDto;
import com.matidominati.orderservice.orderservice.model.entity.OrderEntity;
import com.matidominati.orderservice.orderservice.model.enums.OrderStatus;
import com.matidominati.orderservice.orderservice.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import static com.matidominati.orderservice.orderservice.utils.RepositoryUtils.findByIdOrThrow;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final CartClient cartClient;
    private final OrderMapper mapper;

    public OrderDto getById(String id) {
        log.info("Search process for order with ID: {} has started", id);
        OrderEntity order = findByIdOrThrow(id, orderRepository, OrderEntity.class);
        log.info("Order with ID: {} found", id);
        return mapper.map(order);
    }

    public List<OrderDto> getAll(OrderStatus status) {
        if (status == null) {
            log.info("Search process for all products has started");
            List<OrderDto> orders = orderRepository.findAll().stream()
                    .map(mapper::map)
                    .toList();
            log.info("{} orders found", orders.size());
            return orders;
        }
        log.info("Process of searching for an orders with status: {} has started", status);
        List<OrderDto> orders = orderRepository.findByOrderStatus(status).stream()
                .map(mapper::map)
                .toList();
        log.info("{} orders found", orders.size());
        return orders;
    }

    @Transactional
    public OrderDto create(Long cartId, Customer customer) {
        log.info("Creating order from cart with ID: {}", cartId);
        OrderEntity orderEntity = mapper.map(cartClient.getCart(cartId));
        log.info("Mapping cart to order DTO: {}", orderEntity);
        orderEntity.setCreatedAt(LocalDateTime.now());
        orderEntity.setCustomer(customer);
        log.info("Saving new order: {}", orderEntity);
        orderEntity.setOrderStatus(OrderStatus.NEW);
        orderRepository.save(orderEntity);
        log.info("Order created successfully. New order details: {}", orderEntity);
        return mapper.map(orderEntity);
    }

    @Transactional
    public OrderStatus confirm(String orderId) {
        OrderEntity order = findByIdOrThrow(orderId, orderRepository, OrderEntity.class);
        order.setOrderStatus(OrderStatus.PROCESSING);
        orderRepository.save(order);
        return order.getOrderStatus();
    }

    @Transactional
    public OrderDto modifyCustomerData(String id, OrderEntity updatedOrder) {
        OrderEntity order = findByIdOrThrow(id, orderRepository, OrderEntity.class);
        if (!order.getOrderStatus().equals(OrderStatus.NEW)) {
            log.warn("Cannot modify customer data for order with ID {}. Order status is not 'NEW'.", id);
            throw new OrderModificationException("Cannot modify customer data for a processed order.");
        }
        order.setCustomer(updatedOrder.getCustomer());
        orderRepository.save(order);
        log.info("Customer data modified for order with ID: {}", id);
        return mapper.map(order);
    }

    @Transactional
    public void delete(String id) {
        OrderEntity order = findByIdOrThrow(id, orderRepository, OrderEntity.class);
        orderRepository.delete(order);
    }

}
