package com.bexos.payment_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PaymentRequest(
        @NotNull(message = "orderId is required")
        Long orderId,
        Long price,
        @NotNull(message = "User id is required")
        Long userId,
        @NotBlank(message = "Reference is required")
        String reference,
        @NotBlank(message = "Phone Number is required")
        String phoneNumber
) {
}
