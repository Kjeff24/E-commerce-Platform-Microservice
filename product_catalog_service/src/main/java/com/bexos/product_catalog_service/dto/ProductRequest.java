package com.bexos.product_catalog_service.dto;

import com.bexos.product_catalog_service.model.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductRequest {
    @NotBlank(message = "name field is required")
    String name;
    @NotBlank(message = "description field is required")
    String description;
    @NotNull(message = "price field is required")
    Double price;
    @NotNull(message = "quantity field is required")
    Integer quantity;
    @NotNull(message = "category field is required")
    Long category;
}
