package com.bexos.product_catalog_service.service.impl;

import com.bexos.product_catalog_service.dto.ProductRequest;
import com.bexos.product_catalog_service.dto.ProductResponse;
import com.bexos.product_catalog_service.exception.BadRequestException;
import com.bexos.product_catalog_service.exception.NotFoundException;
import com.bexos.product_catalog_service.model.Product;
import com.bexos.product_catalog_service.repository.CategoryRepository;
import com.bexos.product_catalog_service.repository.ProductRepository;
import com.bexos.product_catalog_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public ProductResponse createProduct(ProductRequest productRequest) {
        if (!categoryRepository.existsByName(productRequest.getCategory())) {
            throw new BadRequestException("Category does not exist: " + productRequest.getCategory());
        }
        return modelMapper.map(productRepository
                .save(modelMapper.map(productRequest, Product.class)), ProductResponse.class);
    }

    public List<ProductResponse> getAllProducts() {

        return productRepository.findAll()
                .stream()
                .map(product -> modelMapper.map(product, ProductResponse.class))
                .toList();
    }

    public ProductResponse getProductById(Long id) {
        return modelMapper.map(productRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found")), ProductResponse.class);
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)) {
            throw new NotFoundException("Product not found");
        }
        productRepository.deleteById(id);
    }
}
