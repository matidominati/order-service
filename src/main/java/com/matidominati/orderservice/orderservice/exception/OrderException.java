package com.matidominati.orderservice.orderservice.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class OrderException extends RuntimeException {

    private final HttpStatus httpStatus;

    public OrderException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}