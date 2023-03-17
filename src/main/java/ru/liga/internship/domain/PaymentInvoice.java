package ru.liga.internship.domain;

import java.math.BigDecimal;

public class PaymentInvoice {
    private final BigDecimal totalAmount;

    public PaymentInvoice(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String toText() {
        return "Вам нужно заплатить "+ totalAmount +" на счёт нашей компании - 0004123400123428";
    }
}
