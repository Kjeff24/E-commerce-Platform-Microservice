package com.bexos.payment_service.controller;

import com.bexos.payment_service.dto.PaymentRequest;
import com.bexos.payment_service.dto.PaymentResponse;
import com.bexos.payment_service.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/payment-service")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @PostMapping("/verify-payment")
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentResponse verifyPayment(@Valid @RequestBody PaymentRequest paymentRequest
    ) throws IOException {
        return paymentService.verifyPayment(paymentRequest);
    }
}
