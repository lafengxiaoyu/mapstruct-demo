//package org.example.mapper;
//
//import org.example.dto.OrderDTO;
//import org.example.dto.OrderItemDTO;
//import org.example.model.Order;
//import org.example.model.OrderItem;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class OrderManualMapperWithIssues {
//
//    public OrderDTO toDto(Order order) {
//        if (order == null) return null;
//
//        OrderDTO dto = new OrderDTO();
//        // Basic fields
//        dto.setOrderId(order.getId().toString());
//        // ❌ 1
//        dto.setCustomerName(order.getCustomer().getName());
//        dto.setOrderDate(order.getCreationDate());
//
//        // 🕳️ Nested object hell
//        if (order.getDeliveryAddress() != null) {
//            dto.setDeliveryStreet(order.getDeliveryAddress().getStreet());
//            // ❌ 2
//            dto.setDeliveryZipCode(order.getDeliveryAddress().getPostalCode());
//        }
//
//        // 🔄 Collection mapping boilerplate
//        List<OrderItemDTO> itemDTOs = new ArrayList<>();
//        double total = 0.0;
//        for (OrderItem item : order.getItems()) {
//            OrderItemDTO itemDTO = new OrderItemDTO();
//            itemDTO.setSku(item.getProduct().getSku());
//            // ❌ 3
//            itemDTO.setQuantiy(item.getQuantity());
//            itemDTO.setUnitPrice(item.getPrice());
//
//            double subtotal = item.getPrice() * item.getQuantity();
//            itemDTO.setSubtotal(subtotal);
//            total += subtotal;
//
//            itemDTOs.add(itemDTO);
//        }
//        dto.setItems(itemDTOs);
//        dto.setTotal(total);
//
//        return dto;
//    }
//}