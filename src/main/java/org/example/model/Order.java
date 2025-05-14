package org.example.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Order {
    Long id;
    Customer customer;
    List<OrderItem> items;
    Address deliveryAddress;
    Date creationDate;
}
