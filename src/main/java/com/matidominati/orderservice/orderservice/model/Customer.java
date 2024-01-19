package com.matidominati.orderservice.orderservice.model;

import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private String firstName;
    private String lastName;
    private Address address;
    private String phoneNumber;
}
