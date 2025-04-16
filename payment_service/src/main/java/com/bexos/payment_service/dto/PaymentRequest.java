package com.bexos.payment_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PaymentRequest(
        @NotNull(message = "Event id is required")
        Integer eventId,
        Integer ticketTierId,
        Integer quantityBought,
        @NotNull(message = "User id is required")
        Integer userId,
        @NotBlank(message = "Reference is required")
        String reference,
        @NotBlank(message = "Phone Number is required")
        String phoneNumber
) {
}
