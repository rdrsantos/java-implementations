package com.strategy.controller;

import com.strategy.application.usecases.ProcessPayment;
import com.strategy.controller.request.PaymentRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pay")
public class PaymentController {

    private final ProcessPayment processPayment;

    public PaymentController(ProcessPayment processPayment) {
        this.processPayment = processPayment;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String pay(@RequestBody PaymentRequest request) {
        return  processPayment.pay(request.value(), request.paymentMethod());
    }
}
