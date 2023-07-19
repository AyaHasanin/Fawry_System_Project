package com.fawry.pack.service.handler;

import com.fawry.pack.service.entity.ServiceInfo;

import java.util.List;

import com.fawry.pack.payment.handler.PaymentStratety;
import com.fawry.pack.discount.entity.Discount;
import com.fawry.pack.discount.handler.DiscountHandler;

public abstract class Service {
    protected ServiceInfo serviceInfo;
    protected PaymentStratety PaymentStratety;

    public PaymentStratety getPaymentStratety() {
        return PaymentStratety;
    }

    public void setPaymentStratety(PaymentStratety paymentStratety) {
        this.PaymentStratety = paymentStratety;
    }

    public abstract String paymentAction(double ammount);

    public double discountAction(double ammount,DiscountHandler discountHandler) {
        List<Discount> discounts = discountHandler.availableDiscount(this.serviceInfo.getServiceName());

        if (discounts != null) {
            for (Discount discount : discounts) {
                ammount = discountHandler.applyDiscount(ammount, discount);
            }
        }
        return ammount;
    }
    
    public String performPayment(double ammount,DiscountHandler discountHandler) {
        ammount = discountAction(ammount,discountHandler);
        return paymentAction(ammount);
    }

    public ServiceInfo getService() {
        return serviceInfo;
    }

    public void setService(ServiceInfo service) {
        this.serviceInfo = service;
    }
    
}
