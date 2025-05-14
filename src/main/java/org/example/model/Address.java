package org.example.model;

import lombok.Data;

@Data
public class Address {
    String street;
    private String city;
    private String postalCode;
}
