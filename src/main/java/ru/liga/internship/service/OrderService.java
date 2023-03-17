package ru.liga.internship.service;

import ru.liga.internship.domain.Order;
import ru.liga.internship.domain.PaymentInvoice;
import ru.liga.internship.domain.Product;

import java.math.BigDecimal;
import java.util.List;

public class OrderService {

    private final PushService pushService;

    public OrderService(PushService pushService) {
        this.pushService = pushService;
    }

    public PaymentInvoice processOrder(Order order) {
        validate(order);
        sendNotificationAboutLoyalProgram(order);
        return buildInvoice(order);
    }

    private void sendNotificationAboutLoyalProgram(Order order) {
        List<Product> products = order.getProducts();
        products.forEach(product -> product.setPrice(BigDecimal.valueOf(product.getPrice().doubleValue() * 0.9)));
        pushService.send("Если вы были нашим клиентом то заплатили бы меньше - " + order.getTotal());
    }

    private PaymentInvoice buildInvoice(Order order) {
        return new PaymentInvoice(order.getTotal());
    }

    private void validate(Order order) {
        if (order.getProducts().isEmpty()) throw new RuntimeException("Order is empty");
    }
}
