package com.bexos.payment_service.service;

import com.bexos.payment_service.dto.PaymentRequest;
import com.bexos.payment_service.dto.PaymentResponse;

import java.io.IOException;

public interface PaymentService {
    PaymentResponse verifyPayment(PaymentRequest paymentRequest) throws IOException;
}
