package com.bexos.product_catalog_service.service.impl;

import com.bexos.product_catalog_service.dto.CategoryRequest;
import com.bexos.product_catalog_service.exception.BadRequestException;
import com.bexos.product_catalog_service.model.Category;
import com.bexos.product_catalog_service.repository.CategoryRepository;
import com.bexos.product_catalog_service.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public Category addCategory(CategoryRequest categoryRequest) {
        if(categoryRepository.existsByName(categoryRequest.getName())) {
            throw new BadRequestException("Category already exists");
        }
        return categoryRepository.save(modelMapper.map(categoryRequest, Category.class));
    }

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }
}
