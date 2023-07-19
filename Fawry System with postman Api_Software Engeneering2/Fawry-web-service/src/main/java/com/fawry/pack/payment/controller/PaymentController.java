package com.fawry.pack.payment.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fawry.pack.payment.handler.PaymentByCreditCard;
import com.fawry.pack.payment.handler.PaymentByWallet;
import com.fawry.pack.payment.handler.PaymentCash;
import com.fawry.pack.payment.handler.PaymentHandler;
import com.fawry.pack.service.handler.Service;
import com.fawry.pack.service.handler.ServiceHandler;

import com.fawry.pack.serviceProvider.handler.ServiceProvider;
import com.fawry.pack.serviceProvider.handler.ServiceProviderHandler;
import com.fawry.pack.user.entity.Customer;
import com.fawry.pack.user.handler.UserHandler;

@RestController
public class PaymentController {
    @Autowired
    private PaymentHandler paymentHandler;
    @Autowired
    private ServiceProviderHandler sProviderHandler;
    @Autowired
    private ServiceHandler serviceHandler;
    @Autowired
    private UserHandler userHandler;

    @GetMapping(value = "/cash/{pName}/{amount}/{userId}")
    public String payCash(@PathVariable("pName") String providerName, @PathVariable("amount") int amount,@PathVariable("userId")int userId) {
        if (this.userHandler.getUserById(userId) == null)
            return "user id not found";
        ServiceProvider serviceProvider = this.sProviderHandler.getServiceByName(providerName);
        if (serviceProvider == null) {
            return "this provider name is not found";
        }
        //serviceHandler = new ServiceHandler(database);
        Service service=this.serviceHandler.getServiceById(serviceProvider.getServiceId());
        if (service == null) {
            return "this service id is not found";
        }
        //paymentHandler = new PaymentHandler(database);
        return paymentHandler.applyPayment(serviceProvider, service, new PaymentCash(), amount);
    }


    @GetMapping(value = "/credit/{pName}/{amount}/{cardNum}/{userId}")
    public String payCredit(@PathVariable("pName") String providerName,@PathVariable("amount") int amount ,@PathVariable("cardNum") String cardNum, @PathVariable("userId")int userId) {
        if (this.userHandler.getUserById(userId) == null)
            return "user id not found";
        ServiceProvider serviceProvider = this.sProviderHandler.getServiceByName(providerName);
        if (serviceProvider == null) {
            return "this provider name is not found";
        }
        //serviceHandler = new ServiceHandler(database);
        Service service=this.serviceHandler.getServiceById(serviceProvider.getServiceId());
        if (service == null) {
            return "this service id is not found";
        }
        return paymentHandler.applyPayment(serviceProvider, service, new PaymentByCreditCard(cardNum), amount);
    
    }

    @GetMapping(value = "/wallet/{pName}/{amount}/{userId}")
    public String payWallet(@PathVariable("pName") String providerName, @PathVariable("amount") int amount,
            @PathVariable("userId") int userId) {
        //this.sProviderHandler = new ServiceProviderHandler(database);

        ServiceProvider serviceProvider = this.sProviderHandler.getServiceByName(providerName);
        if (serviceProvider == null) {
            return "this provider name is not found";
        }
        //serviceHandler = new ServiceHandler(database);
        Service service = this.serviceHandler.getServiceById(serviceProvider.getServiceId());
        if (service == null) {
            return "this service id is not found";
        }
        Customer user = (Customer) this.userHandler.getUserById(userId);
        if (user == null) {
            return "no user found wih this id";
        }
        return paymentHandler.applyPayment(serviceProvider, service, new PaymentByWallet(user), amount);

    }

    @GetMapping(value = "/payment/trans/{userId}")
    public List<String> getPaymentTransaction(@PathVariable("userId")int userId) {
        if (this.userHandler.getUserById(userId) == null)
            return null;
        return this.paymentHandler.getPaymentTransactions();
    }
}
