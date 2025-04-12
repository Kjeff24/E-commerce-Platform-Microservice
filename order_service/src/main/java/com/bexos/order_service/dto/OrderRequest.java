package com.bexos.order_service.dto;

import com.bexos.order_service.model.OrderStatus;
import com.bexos.order_service.util.validator.ValidOrderStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    @NotNull(message = "userId field is required")
    private Long userId;
    private List<OrderItemRequest> orderItems;
}
