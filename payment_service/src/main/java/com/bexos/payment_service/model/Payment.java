package com.bexos.payment_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    private Double amount;
    private String customerEmail;
    private String currency;
    private String cardType;
    private String mobileMoneyNumber;
    private String bank;
    private String brand;
    private String channel;
    private LocalDate transactionDate;
    private LocalTime transactionTime;
    private Long userId;
    private Long orderId;
}
