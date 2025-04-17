package com.bexos.payment_service.service.impl;

import com.bexos.payment_service.dto.PayStackSuccessResponse;
import com.bexos.payment_service.dto.PaymentRequest;
import com.bexos.payment_service.dto.PaymentResponse;
import com.bexos.payment_service.exception.InternalServerErrorException;
import com.bexos.payment_service.mapper.PaymentMapper;
import com.bexos.payment_service.model.Payment;
import com.bexos.payment_service.repository.PaymentRepository;
import com.bexos.payment_service.service.PaymentService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final RestClient restClient;
    private final PaymentMapper paymentMapper;

    @Value("${paystack.secret}")
    String payStackSecretKey;
    @Value("${paystack.verify.url}")
    String payStackVerifyUrl;

    private ResponseEntity<String> executeGetRequest(String reference) {
        return restClient.get()
                .uri(payStackVerifyUrl + "/" + reference)
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer " + payStackSecretKey)
                .retrieve()
                .toEntity(String.class);
    }

    public PaymentResponse verifyPayment(PaymentRequest paymentRequest) throws IOException {
        ResponseEntity<String> response = executeGetRequest(paymentRequest.reference());
        HttpStatusCode statusCode = response.getStatusCode();

        if (statusCode == HttpStatus.BAD_REQUEST) {
            throw new BadRequestException("Transaction reference not found");
        } else if (statusCode == HttpStatus.OK) {
            String payStackResponseBody = response.getBody();
            Gson gson = new Gson();
            PayStackSuccessResponse payStackSuccessResponse = gson
                    .fromJson(payStackResponseBody, PayStackSuccessResponse.class);
            Payment payment = paymentMapper.toPayment(payStackSuccessResponse, paymentRequest.userId(), paymentRequest.orderId());
//            paymentRepository.save(payment);
            try {
                return paymentMapper.toPaymentResponse(payment);
            } catch (MessagingException e) {
                throw new InternalServerErrorException("Error sending email");
            }
        }

        throw new InternalServerErrorException("An error occurred while verifying payment.");
    }
}
