package com.matidominati.orderservice.orderservice.model;

import lombok.Data;

@Data
public class Address {

    private String city;
    private String zipCode;
    private String street;
    private int houseNumber;
}
