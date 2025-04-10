package com.bexos.order_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrderItemRequest {
    @NotNull(message = "productId field is required")
    private Long productId;
    @NotNull(message = "quantity field is required")
    private Integer quantity;
    @NotNull(message = "price field is required")
    private Double price;
}
