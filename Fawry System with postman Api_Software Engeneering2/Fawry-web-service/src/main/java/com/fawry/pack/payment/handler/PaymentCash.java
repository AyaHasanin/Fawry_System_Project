package com.fawry.pack.payment.handler;


public class PaymentCash implements PaymentStratety{

    @Override
    public String  pay(double ammount) {
        //System.out.println("apply payment cash recieve "+ammount+" dollar");
        return "apply payment cash recieve total ammount = " + ammount + " dollar";
    }
    
}
