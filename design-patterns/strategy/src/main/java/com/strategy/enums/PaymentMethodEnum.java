package com.strategy.enums;

public enum PaymentMethodEnum {
    PIX,
    DEBIT,
    CREDIT,
    BILL,
    PAYPAL;

     public static PaymentMethodEnum fromString(String method) {
        try {
            return PaymentMethodEnum.valueOf(method.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Metodo de pagamento näo suportado");
        }

    }
}
