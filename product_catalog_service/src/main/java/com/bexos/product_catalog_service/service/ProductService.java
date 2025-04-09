package com.bexos.product_catalog_service.service;

import com.bexos.product_catalog_service.dto.ProductRequest;
import com.bexos.product_catalog_service.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest productRequest);
    List<ProductResponse> getAllProducts();
    ProductResponse getProductById(Long id);
    void deleteProduct(Long id);
}
