package com.matidominati.orderservice.orderservice.exception;

import org.springframework.http.HttpStatus;

public class OrderModificationException extends OrderException{
    public OrderModificationException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
