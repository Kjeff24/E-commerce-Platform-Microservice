package com.bexos.payment_service.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

@Builder
public record Data(
        @SerializedName("status") String status,
        @SerializedName("reference") String reference,
        @SerializedName("amount") double amount,
        @SerializedName("currency") String currency,
        @SerializedName("authorization") Authorization authorization,
        @SerializedName("customer") Customer customer,
        @SerializedName("transaction_date") String transactionDate
) {
}
