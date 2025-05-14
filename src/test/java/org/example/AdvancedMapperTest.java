package org.example;

import org.example.dto.OrderDTO;
import org.example.mapper.AdvancedOrderMapStructMapper;
import org.example.mapper.AdvancedOrderMapStructMapperImpl;
import org.example.model.Address;
import org.example.model.Customer;
import org.example.model.Order;
import org.example.model.OrderItem;
import org.example.model.Product;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdvancedMapperTest {

    private final AdvancedOrderMapStructMapper mapStructMapper = new AdvancedOrderMapStructMapperImpl();

    @Test
    public void testMappers() {
        Order order = createTestOrder();

        // MapStruct mapping
        OrderDTO mapstructDto = mapStructMapper.orderToDto(order);

        System.out.println("Advanced MapStruct DTO:\n \t" + mapstructDto);
        assertEquals("1181TS", mapstructDto.getDeliveryZipCode());
        assertEquals(120.98, mapstructDto.getTotal());
        assertEquals("1001", mapstructDto.getItems().get(0).getSku());
        assertEquals("9999", mapstructDto.getItems().get(1).getSku());
        assertEquals("123-Main-St", mapstructDto.getDeliveryStreet());
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