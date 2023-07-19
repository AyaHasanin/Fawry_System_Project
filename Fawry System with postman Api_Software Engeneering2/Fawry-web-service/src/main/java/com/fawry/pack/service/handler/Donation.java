package com.fawry.pack.service.handler;

import com.fawry.pack.service.entity.DonationServiceInfo;

public class Donation extends Service  {


    public Donation() {
        this.serviceInfo = new DonationServiceInfo();       
    }

    @Override
    public String paymentAction(double ammount) {
        return this.PaymentStratety.pay(ammount);
    }

 
    
}
