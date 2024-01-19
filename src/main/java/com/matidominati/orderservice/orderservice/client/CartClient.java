package com.matidominati.orderservice.orderservice.client;

import com.matidominati.orderservice.orderservice.client.model.CartDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

@FeignClient(name = "cart-service", url = "${cart.service.api.url")
public interface CartClient {

    @GetMapping("/carts/{cartId}")
    public CartDto getCart(@PathVariable Long cartId);

    @GetMapping("/carts/{cartId}/totalPrice")
    public BigDecimal getTotalPrice(@PathVariable Long cartId);
}
