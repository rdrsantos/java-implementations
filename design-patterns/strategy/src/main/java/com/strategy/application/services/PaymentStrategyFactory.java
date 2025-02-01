package com.strategy.application.services;

import com.strategy.application.usecases.PaymentStrategy;
import com.strategy.enums.PaymentMethodEnum;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PaymentStrategyFactory {

    private final Map<PaymentMethodEnum, PaymentStrategy> strategies;

    public PaymentStrategyFactory(Map<String, PaymentStrategy> mapStrategy) {
        this.strategies = new HashMap<>();
        for (PaymentMethodEnum method : PaymentMethodEnum.values()) {
            this.strategies.put(method, mapStrategy.get(method.name().toLowerCase()+"PaymentStrategy"));
        }
    }

    public PaymentStrategy getStrategy(PaymentMethodEnum methodsEnum) {
        return this.strategies.get(methodsEnum);
    }
}
