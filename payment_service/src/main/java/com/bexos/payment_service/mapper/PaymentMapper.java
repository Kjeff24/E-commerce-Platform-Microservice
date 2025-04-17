package com.bexos.payment_service.mapper;

import com.bexos.payment_service.dto.PayStackSuccessResponse;
import com.bexos.payment_service.dto.PaymentResponse;
import com.bexos.payment_service.model.Payment;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class PaymentMapper {

    public Payment toPayment(PayStackSuccessResponse payStackSuccessResponse, Long userId, Long orderId) {
        ZonedDateTime zonedDateTime = ZonedDateTime
                .parse(
                        payStackSuccessResponse.data().transactionDate(),
                        DateTimeFormatter.ISO_DATE_TIME
                );
        return Payment.builder()
                .amount(payStackSuccessResponse.data().amount() / 100)
                .reference(payStackSuccessResponse.data().reference())
                .currency(payStackSuccessResponse.data().currency())
                .transactionDate(zonedDateTime.toLocalDate())
                .transactionTime(zonedDateTime.toLocalTime())
                .customerEmail(payStackSuccessResponse.data().customer().email())
                .channel(payStackSuccessResponse.data().authorization().channel())
                .cardType(payStackSuccessResponse.data().authorization().cardType())
                .bank(payStackSuccessResponse.data().authorization().bank())
                .brand(payStackSuccessResponse.data().authorization().brand())
                .mobileMoneyNumber(payStackSuccessResponse.data().authorization().mobileMoneyNumber())
                .userId(userId)
                .orderId(orderId)
                .build();
    }

    public PaymentResponse toPaymentResponse(Payment payment) {
        return PaymentResponse.builder()
                .id(payment.getId())
                .userId(payment.getUserId())
                .orderId(payment.getOrderId())
                .reference(payment.getReference())
                .amount(payment.getAmount())
                .customerEmail(payment.getCustomerEmail())
                .currency(payment.getCurrency())
                .cardType(payment.getCardType())
                .mobileMoneyNumber(payment.getMobileMoneyNumber())
                .bank(payment.getBank())
                .brand(payment.getBrand())
                .channel(payment.getChannel())
                .transactionDate(payment.getTransactionDate())
                .transactionTime(payment.getTransactionTime())
                .build();
    }
}
