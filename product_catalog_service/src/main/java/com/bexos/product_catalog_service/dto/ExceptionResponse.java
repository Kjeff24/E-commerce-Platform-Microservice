package com.bexos.product_catalog_service.dto;


import lombok.Builder;

@Builder
public record ExceptionResponse(
        String message
) {
}
