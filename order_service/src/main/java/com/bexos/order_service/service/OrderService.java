package com.bexos.order_service.service;

import com.bexos.order_service.dto.OrderRequest;
import com.bexos.order_service.dto.OrderResponse;

import java.util.List;

public interface OrderService {
    OrderResponse createOrder(OrderRequest orderRequest);
    List<OrderResponse> getOrdersByUserId(Long userId);
    OrderResponse getOrderById(Long id);
    List<OrderResponse> getAllOrders();
}
