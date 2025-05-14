package org.example.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {
    private String orderId;
    private String customerName;
    private Date orderDate;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryZipCode;
    private List<OrderItemDTO> items;
    private double total;
}

