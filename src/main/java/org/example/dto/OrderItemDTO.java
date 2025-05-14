package org.example.dto;

import lombok.Data;

@Data
public class OrderItemDTO {
    private String sku;
    private int quantity;
    private double unitPrice;
    private double subtotal;
}
