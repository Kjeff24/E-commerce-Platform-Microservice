package com.bexos.order_service.util.validator;

import com.bexos.order_service.model.OrderStatus;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = OrderStatusValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidOrderStatus {
    OrderStatus[] value();
    String message() default "Invalid order status";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
