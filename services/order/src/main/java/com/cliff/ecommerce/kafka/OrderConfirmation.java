package com.cliff.ecommerce.kafka;

import com.cliff.ecommerce.customer.CustomerResponse;
import com.cliff.ecommerce.order.PaymentMethod;
import com.cliff.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String OrderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {

}
