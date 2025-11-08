package com.cliff.ecommerce.kafka.order;

import com.cliff.ecommerce.kafka.payment.PaymentConfirmation;
import com.cliff.ecommerce.kafka.payment.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation (
    String orderReference,
    BigDecimal totalAmount,
    PaymentMethod paymentMethod,
    Customer customer,
    List<Product> products
){

}
