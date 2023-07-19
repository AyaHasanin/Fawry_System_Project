package com.fawry.pack.service.handler;

import com.fawry.pack.payment.handler.reciet.MonthlyReciet;
import com.fawry.pack.payment.handler.reciet.RecietStrategy;
import com.fawry.pack.service.entity.LandLineServiceInfo;


public class LandLineService extends Service{
   
    private RecietStrategy strategy;
    
    public LandLineService() {
        this.serviceInfo = new LandLineServiceInfo();
        strategy = new MonthlyReciet();

    }
    public RecietStrategy getStrategy() {
        return strategy;
    }
    public void setStrategy(RecietStrategy strategy) {
        this.strategy = strategy;
    }
    @Override
    public String paymentAction(double ammount) {

        return strategy.payReciet(this.PaymentStratety);

    }
}
