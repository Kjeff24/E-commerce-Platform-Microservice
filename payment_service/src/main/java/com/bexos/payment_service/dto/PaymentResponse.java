package com.bexos.payment_service.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
public record PaymentResponse(
        Long id,
        Long userId,
        Long orderId,
        String reference,
        Double amount,
        String customerEmail,
        String currency,
        String cardType,
        String mobileMoneyNumber,
        String bank,
        String brand,
        String channel,
        LocalDate transactionDate,
        LocalTime transactionTime

) {
}
