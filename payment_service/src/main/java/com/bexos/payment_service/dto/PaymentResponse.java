package com.bexos.payment_service.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record PaymentResponse(
        Integer id,
        Integer userId,
        Integer eventId,
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
