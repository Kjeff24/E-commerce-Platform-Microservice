package com.bexos.notification_service.dto;


import lombok.Builder;

@Builder
public record ExceptionResponse(
        String message
) {
}
