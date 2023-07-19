package com.fawry.pack.payment.handler;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fawry.pack.discount.handler.DiscountHandler;
import com.fawry.pack.service.handler.Service;
import com.fawry.pack.serviceProvider.handler.ServiceProvider;


@org.springframework.stereotype.Service
public class PaymentHandler {
    private List<String> paymentTransaction;

    public PaymentHandler() {
        this.paymentTransaction = new ArrayList<>();
    }

    public String applyPayment(ServiceProvider serviceProvider, Service service, PaymentStratety paymentStratety,
            double ammount) {
        service.setPaymentStratety(paymentStratety);
        String trans = (service.performPayment(ammount, new DiscountHandler()) + "by provider "
                + serviceProvider.getsProviderInfo().getProvidername() + "  ");
        this.paymentTransaction.add((trans + LocalDateTime.now().toString()));
        return trans;

    }

    
    public List<String> getPaymentTransactions() {
        return this.paymentTransaction;
    }
}
