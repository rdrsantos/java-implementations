package com.strategy.application.usecases;

public interface ProcessPayment {
    String pay(Double value, String paymentMethod);
}
