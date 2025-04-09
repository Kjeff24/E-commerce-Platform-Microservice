package com.bexos.product_catalog_service.dto;

import com.bexos.product_catalog_service.model.Category;
import lombok.Data;

@Data
public class ProductResponse {
    Long id;
    String name;
    String description;
    double price;
    int quantity;
    Category category;
}
