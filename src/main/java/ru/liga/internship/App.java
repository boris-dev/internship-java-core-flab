package ru.liga.internship;

import ru.liga.internship.domain.Order;
import ru.liga.internship.domain.PaymentInvoice;
import ru.liga.internship.domain.Product;
import ru.liga.internship.service.OrderService;
import ru.liga.internship.service.PushService;

import java.math.BigDecimal;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Product product1 = new Product("Книга", BigDecimal.valueOf(200.0), "Хорошая книга");
        Product product2 = new Product("Флешка", BigDecimal.valueOf(50.0), "Быстрая флешка");

        Order order = new Order();
        order.addProduct(product1);
        order.addProduct(product2);
        PushService pushService = new PushService();
        PaymentInvoice paymentInvoice = new OrderService(pushService).processOrder(order);

        System.out.println(paymentInvoice.toText());

    }
}
