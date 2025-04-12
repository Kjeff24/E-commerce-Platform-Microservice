package com.bexos.order_service.dto;

import com.bexos.order_service.model.OrderItem;
import com.bexos.order_service.model.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderResponse {
    private Long id;
    private Long userId;
    private LocalDateTime orderDate;
    private OrderStatus status;
    private List<OrderItem> items;
}
