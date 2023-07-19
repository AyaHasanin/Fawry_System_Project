package com.fawry.pack.service.handler;

import com.fawry.pack.service.entity.InternetPaymentServiceInfo;

public class InternetPaymentService extends Service{

    // public InternetPaymentService(User user) {
    //     super(user);
    // }

    public InternetPaymentService() {
        
        this.serviceInfo = new InternetPaymentServiceInfo(); 
    }

    @Override
    public String paymentAction(double ammount) {
        return this.PaymentStratety.pay(ammount);
    }
    
    
}
