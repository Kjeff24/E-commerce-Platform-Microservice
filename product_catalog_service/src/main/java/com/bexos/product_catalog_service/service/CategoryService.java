package com.bexos.product_catalog_service.service;

import com.bexos.product_catalog_service.dto.CategoryRequest;
import com.bexos.product_catalog_service.model.Category;

import java.util.List;

public interface CategoryService {
    Category addCategory(CategoryRequest categoryRequest);

    List<Category> getAllCategory();
}
