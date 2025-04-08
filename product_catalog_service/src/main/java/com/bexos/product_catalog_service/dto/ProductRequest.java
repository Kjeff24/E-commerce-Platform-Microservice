package com.bexos.product_catalog_service.dto;

import lombok.Data;

@Data
public class ProductRequest {
    String name;
    String description;
    double price;
    int quantity;
    String category;
}
