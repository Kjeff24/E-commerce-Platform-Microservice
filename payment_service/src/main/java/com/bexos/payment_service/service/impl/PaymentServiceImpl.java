package com.bexos.payment_service.service.impl;

import com.bexos.payment_service.dto.PaymentRequest;
import com.bexos.payment_service.dto.PaymentResponse;
import com.bexos.payment_service.repository.PaymentRepository;
import com.bexos.payment_service.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    @Value("${paystack.secret}")
    String payStackSecretKey;
    @Value("${paystack.verify.url}")
    String payStackVerifyUrl;
    String authorizationHeader = "Bearer ";

    public PaymentResponse verifyPayment(PaymentRequest paymentRequest) throws IOException {
        return null;
    }
}
