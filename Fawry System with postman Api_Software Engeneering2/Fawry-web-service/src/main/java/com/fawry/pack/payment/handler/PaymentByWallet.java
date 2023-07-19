package com.fawry.pack.payment.handler;

import com.fawry.pack.user.entity.Customer;
import com.fawry.pack.user.handler.WalletHandler;

public class PaymentByWallet implements PaymentStratety{
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public PaymentByWallet(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String pay(double ammount) {
        WalletHandler walletHandler = new WalletHandler(this.customer.getWallet());
        if(walletHandler.reduceMoney(ammount))
            return ("apply payment by wallet reduce " + ammount + " doller");
        return "wallet amount just has " + customer.getWallet().getMoney() + " $ and process requierd at least " + ammount
                + "$";
    }
    
}
