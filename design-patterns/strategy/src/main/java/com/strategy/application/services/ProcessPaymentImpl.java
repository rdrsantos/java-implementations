package com.strategy.application.services;

import com.strategy.application.usecases.ProcessPayment;
import com.strategy.enums.PaymentMethodEnum;
import org.springframework.stereotype.Service;

@Service
public class ProcessPaymentImpl implements ProcessPayment {

    private final PaymentStrategyFactory factory;

    public ProcessPaymentImpl(PaymentStrategyFactory factory) {
        this.factory = factory;
    }

    @Override
    public String pay(Double value, String paymentMethod) {
        return factory.getStrategy(PaymentMethodEnum.fromString(paymentMethod)).pay(value);
    }
}
