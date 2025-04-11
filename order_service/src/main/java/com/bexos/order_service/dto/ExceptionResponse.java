package com.bexos.order_service.dto;


import lombok.Builder;

@Builder
public record ExceptionResponse(
        String message
) {
}
