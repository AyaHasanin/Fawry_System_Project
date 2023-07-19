package com.fawry.pack.payment.handler.reciet;

import com.fawry.pack.payment.handler.PaymentStratety;

public class QuarterReciet implements RecietStrategy{

    private final double quarterRecietAmmount=300;
    @Override
    public String payReciet(PaymentStratety paymentStratety) {
        System.out.println("apply quarter reciet");
        return ("apply quarter reciet" + paymentStratety.pay(quarterRecietAmmount));
    }
    
}
