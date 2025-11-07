package com.cliff.ecommerce.payment;

import com.cliff.ecommerce.customer.CustomerResponse;
import com.cliff.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
