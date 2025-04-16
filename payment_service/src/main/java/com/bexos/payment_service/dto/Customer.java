package com.bexos.payment_service.dto;

import com.google.gson.annotations.SerializedName;

public record Customer(
        @SerializedName("email") String email
) {
}
