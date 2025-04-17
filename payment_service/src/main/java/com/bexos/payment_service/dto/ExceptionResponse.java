package com.bexos.payment_service.dto;


import lombok.Builder;

@Builder
public record ExceptionResponse(
        String message
) {
}
