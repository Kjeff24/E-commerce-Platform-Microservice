package com.bexos.order_service.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    @NotNull(message = "userId field is required")
    private Long userId;
    @NotNull(message = "orderItems field is required")
    @NotEmpty(message = "orderItems cannot be empty")
    @Valid
    private List<OrderItemRequest> orderItems;
}
