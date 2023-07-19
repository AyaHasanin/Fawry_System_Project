package com.fawry.pack.payment.handler.reciet;

import com.fawry.pack.payment.handler.PaymentStratety;

public class MonthlyReciet implements RecietStrategy{
    private final double monthlyRecietAmmount=100;
    @Override
    public String payReciet(PaymentStratety paymentStratety) {
        System.out.println("apply monthly reciet");
        return ("apply monthly reciet\n" + paymentStratety.pay(monthlyRecietAmmount));
    }
    
}
