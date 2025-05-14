package org.example.model;

import lombok.Data;

@Data
public class OrderItem {
    private Product product;
    private int quantity;
    private double price;
}
