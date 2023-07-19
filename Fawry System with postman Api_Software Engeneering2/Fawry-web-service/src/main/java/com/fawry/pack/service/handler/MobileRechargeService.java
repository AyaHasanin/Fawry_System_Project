package com.fawry.pack.service.handler;

import com.fawry.pack.service.entity.MobileRechargeServiceInfo;

public class MobileRechargeService extends Service{

    // public MobileRechargeService(User user) {
    //     super(user);
    //     this.ServiceName = "MoblieCharge";
    // }
    public MobileRechargeService() {
        this.serviceInfo = new MobileRechargeServiceInfo();
    }

    @Override
    public String paymentAction(double ammount) {
        return this.PaymentStratety.pay(ammount);
    }
    
}

