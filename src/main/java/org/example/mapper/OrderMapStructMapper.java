package org.example.mapper;

import org.example.dto.OrderDTO;
import org.example.dto.OrderItemDTO;
import org.example.model.Order;
import org.example.model.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        imports = Collectors.class)
public interface OrderMapStructMapper {

    @Mapping(target = "orderId", source = "id")
    @Mapping(target = "customerName", source = "customer.name")
    @Mapping(target = "orderDate", source = "creationDate")
    @Mapping(target = "deliveryStreet", source = "deliveryAddress.street")
    @Mapping(target = "deliveryCity", source = "deliveryAddress.city")
    @Mapping(target = "deliveryZipCode", source = "deliveryAddress.postalCode")
    @Mapping(target = "items", source = "items")
    @Mapping(target = "total",
            expression = "java(order.getItems().stream()" + // Calculate total
                    ".mapToDouble(item -> item.getPrice() * item.getQuantity())" +
                    ".sum())")
    OrderDTO orderToDto(Order order);

    /**
     * Converts OrderItem to OrderItemDTO with:
     * - Nested property mapping (product.sku → sku)
     * - Field renaming (price → unitPrice)
     * - Calculated field (subtotal)
     */
    @Mapping(target = "sku", source = "product.sku")
    @Mapping(target = "unitPrice", source = "price")
    @Mapping(target = "subtotal", expression = "java(item.getPrice() * item.getQuantity())")
    OrderItemDTO toOrderItemDto(OrderItem item);
}