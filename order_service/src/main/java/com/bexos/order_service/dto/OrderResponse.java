package com.bexos.order_service.dto;

import com.bexos.order_service.model.OrderItem;

import java.time.LocalDateTime;
import java.util.List;

public class OrderResponse {
    private Long id;
    private Long userId;
    private LocalDateTime orderDate;
    private String status;
    private List<OrderItem> items;
}
