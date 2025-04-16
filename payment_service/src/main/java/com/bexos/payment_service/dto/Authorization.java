package com.bexos.payment_service.dto;

import com.google.gson.annotations.SerializedName;

public record Authorization(
        @SerializedName("channel") String channel,
        @SerializedName("bank") String bank,
        @SerializedName("card_type") String cardType,
        @SerializedName("brand") String brand,
        @SerializedName("mobile_money_number") String mobileMoneyNumber
) {
}
