package com.bexos.product_catalog_service.dto;

public record ProductRequest(
        String name,
        String description,
        double price,
        int quantity,
        String category
) {
}
