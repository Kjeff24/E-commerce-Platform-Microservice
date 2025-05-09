package com.bexos.order_service.service.impl;

import com.bexos.order_service.dto.OrderRequest;
import com.bexos.order_service.dto.OrderResponse;
import com.bexos.order_service.exception.NotFoundException;
import com.bexos.order_service.model.Order;
import com.bexos.order_service.repository.OrderRepository;
import com.bexos.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public OrderResponse createOrder(OrderRequest orderRequest) {
        Order order = modelMapper.map(orderRequest, Order.class);
        return modelMapper.map(orderRepository.save(order), OrderResponse.class);
    }


    public List<OrderResponse> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId).stream()
                .map(order -> modelMapper.map(order, OrderResponse.class))
                .toList();
    }

    public OrderResponse getOrderById(Long id) {
        return modelMapper.map(orderRepository.findById(id).orElseThrow(() -> new NotFoundException("Order not found")), OrderResponse.class);
    }

    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(order -> modelMapper.map(order, OrderResponse.class))
                .toList();
    }

    @Override
    public void deleteOrderById(Long orderId) {
        if(!orderRepository.existsById(orderId)) {
            throw new NotFoundException("Order not found");
        }
        orderRepository.deleteById(orderId);
    }
}
