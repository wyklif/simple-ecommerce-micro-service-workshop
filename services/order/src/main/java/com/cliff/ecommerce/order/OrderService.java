package com.cliff.ecommerce.order;


import com.cliff.ecommerce.OrderProducer;
import com.cliff.ecommerce.customer.CustomerClient;
import com.cliff.ecommerce.exception.BusinessException;
import com.cliff.ecommerce.kafka.OrderConfirmation;
import com.cliff.ecommerce.orderline.OrderLineRequest;
import com.cliff.ecommerce.orderline.OrderLineService;
import com.cliff.ecommerce.payment.PaymentClient;
import com.cliff.ecommerce.payment.PaymentRequest;
import com.cliff.ecommerce.product.ProductClient;
import com.cliff.ecommerce.product.PurchaseRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;
    public Integer createOrder(OrderRequest request) {
        // check the customer --> Open Feign
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot Create Order. Customer Not Found with ID: " + request.customerId()));
        // purchase the products --> products-ms (Rest Template)
        var purchasedProducts = this.productClient.purchaseProducts(request.products());

        //persist order
        var order = this.orderRepository.save(orderMapper.toOrder(request));
        // persist order lines
        for (PurchaseRequest purchaseRequest : request.products()) {

            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );

        }

        var paymentRequest = new PaymentRequest(
                request.amount(),
                request.paymentMethod(),
                order.getId(),
                order.getReference(),
                customer
        );

        paymentClient.requestOrderPayment(paymentRequest);
        //send order confirmation to notification ms (Kafka)
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchasedProducts

                )
        );
        return order.getId();
    }

    public List<OrderResponse> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::fromOrder)
                .collect(Collectors.toList());
    }

    public OrderResponse findById(Integer orderId) {
        return orderRepository.findById(orderId)
                .map(orderMapper::fromOrder)
                .orElseThrow(() -> new EntityNotFoundException("No order found with id "+ orderId));
    }
}
