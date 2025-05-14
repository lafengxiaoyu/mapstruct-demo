package org.example;

import org.example.dto.OrderDTO;
import org.example.mapper.OrderManualMapper;
import org.example.mapper.OrderMapStructMapper;
import org.example.mapper.OrderMapStructMapperImpl;
import org.example.model.*;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MapperTest {

    private final OrderMapStructMapper mapStructMapper = new OrderMapStructMapperImpl();
    private final OrderManualMapper manualMapper = new OrderManualMapper();

    @Test
    public void testMappers() {
        Order order = createTestOrder();

        // Manual mapping
        OrderDTO manualDto = manualMapper.toDto(order);
        assertNotNull(manualDto);

        // MapStruct mapping
        OrderDTO mapstructDto = mapStructMapper.orderToDto(order);
        assertNotNull(mapstructDto);

        // Verify both produce same results
        assertEquals(manualDto.getTotal(), mapstructDto.getTotal());
    }

    private Order createTestOrder() {
        var order = new Order();
        order.setId(1L);
        order.setCreationDate(new Date());

        var customer = new Customer();
        customer.setName("John Doe");
        order.setCustomer(customer);

        var address = new Address();
        address.setStreet("123 Main St");
        address.setCity("Springfield");
        order.setDeliveryAddress(address);

        var product = new Product();
        product.setSku("SKU-1001");

        var item = new OrderItem();
        item.setProduct(product);
        item.setQuantity(2);
        item.setPrice(19.99);
        order.setItems(List.of(item));

        return order;
    }
}