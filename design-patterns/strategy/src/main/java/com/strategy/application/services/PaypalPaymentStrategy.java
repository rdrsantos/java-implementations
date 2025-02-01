package com.strategy.application.services;

import com.strategy.application.usecases.PaymentStrategy;
import org.springframework.stereotype.Service;

@Service
public class PaypalPaymentStrategy implements PaymentStrategy {
    @Override
    public String pay(Double value) {
        return "Valor de R$ " + value + " pago com metodo de pagamento PayPal!";
    }
}
