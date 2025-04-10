package com.bexos.order_service.util.validator;


import com.bexos.order_service.model.OrderStatus;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Set;

public class OrderStatusValidator implements ConstraintValidator<
        ValidOrderStatus, OrderStatus> {

    private Set<OrderStatus> allowedValues;

    @Override
    public void initialize(ValidOrderStatus constraintAnnotation) {
        this.allowedValues = Set.of(constraintAnnotation.value());
    }

    @Override
    public boolean isValid(OrderStatus value, ConstraintValidatorContext context) {
        return value == null || allowedValues.contains(value);
    }
}
