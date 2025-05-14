package org.example.mapper;

import org.example.dto.OrderDTO;
import org.example.dto.OrderItemDTO;
import org.example.model.Address;
import org.example.model.Order;
import org.example.model.OrderItem;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring",
        imports = Collectors.class)
public interface AdvancedOrderMapStructMapper {

    @Mapping(target = "orderId", source = "id")
    @Mapping(target = "customerName", source = "customer.name")
    @Mapping(target = "orderDate", source = "creationDate")
    @Mapping(target = "deliveryStreet", source = "deliveryAddress", qualifiedByName = "setStreetAddress") // 1.
    @Mapping(target = "deliveryCity", source = "deliveryAddress.city")
    @Mapping(target = "deliveryZipCode", source = "deliveryAddress.postalCode", defaultValue = "1181TS") // 3.
    @Mapping(target = "items", source = "items")
    @Mapping(target = "total",
            expression = "java(order.getItems().stream()" +
                    ".mapToDouble(item -> item.getPrice() * item.getQuantity())" +
                    ".sum())")
    OrderDTO orderToDto(Order order);

    @Named("setStreetAddress")
    default String formatAddress(Address address) {
        return address.getStreet().replaceAll(" ", "-");
    }

    /**
     * Converts OrderItem to OrderItemDTO with:
     * - Nested property mapping (product.sku → sku)
     * - Field renaming (price → unitPrice)
     * - Calculated field (subtotal)
     */
    @Mapping(target = "sku", source = "product.sku", qualifiedByName = "removeSKUPrefix") // 2.
    @Mapping(target = "unitPrice", source = "price")
    @Mapping(target = "subtotal", expression = "java(item.getPrice() * item.getQuantity())")
    OrderItemDTO toOrderItemDto(OrderItem item);

    @Named("removeSKUPrefix")
    default String setSKU(String sku) {
        if (sku != null && sku.startsWith("SKU-")) {
            return sku.substring(4);
        }
        return sku;
    }

    @AfterMapping // 4.
    default void afterMapping(@MappingTarget OrderDTO orderDTO) {
        // Custom logic after mapping
        orderDTO.setTotal(Math.round(orderDTO.getTotal() * 100.0) / 100.0);
    }

}