package com.bexos.product_catalog_service.repository;

import com.bexos.product_catalog_service.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
