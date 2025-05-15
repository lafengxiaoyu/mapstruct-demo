package org.example;

import org.example.dto.OrderDTO;
import org.example.mapper.OrderManualMapper;
import org.example.mapper.OrderMapStructMapper;
import org.example.mapper.OrderMapStructMapperImpl;
import org.example.model.Address;
import org.example.model.Customer;
import org.example.model.Order;
import org.example.model.OrderItem;
import org.example.model.Product;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapperTest {

    private final OrderMapStructMapper mapStructMapper = new OrderMapStructMapperImpl();
    private final OrderManualMapper manualMapper = new OrderManualMapper();

    @Test
    public void testMappers() {
        Order order = createTestOrder();

        // Manual mapping
        OrderDTO manualDto = manualMapper.toDto(order);

        // MapStruct mapping
        OrderDTO mapstructDto = mapStructMapper.orderToDto(order);

        System.out.println("Manual DTO:\n \t" + manualDto + "\n" + "MapStruct DTO:\n \t" + mapstructDto);

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

        var product1 = new Product();
        product1.setSku("SKU-1001");

        var item1 = new OrderItem();
        item1.setProduct(product1);
        item1.setQuantity(2);
        item1.setPrice(19.99);

        var product2 = new Product();
        product2.setSku("SKU-9999");

        var item2 = new OrderItem();
        item2.setProduct(product2);
        item2.setQuantity(9);
        item2.setPrice(9);

        order.setItems(List.of(item1, item2));

        return order;
    }
}