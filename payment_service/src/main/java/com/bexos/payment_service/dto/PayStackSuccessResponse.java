package com.bexos.payment_service.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

@Builder
public record PayStackSuccessResponse(
        @SerializedName("status") boolean status,
        @SerializedName("message") String message,
        @SerializedName("data") Data data
) {
}
