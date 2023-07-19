package com.fawry.pack.refund.entity;

import com.fawry.pack.service.entity.ServiceInfo;

public class Refund {
    private double amount;
    private ServiceInfo service;
    private RefundState refundState;
    private static int id = 1;
    private int refondID;
    private int userId;


  
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    /*
        {
            "amount":5,
            "service":{
                "serviceName":"mob"
            },
            "user": {
                "email":"",
                "userId":5
            }
        }
    
    
        }
    */
    public ServiceInfo getService() {
        return service;
    }

    public void setService(ServiceInfo service) {
        this.service = service;
    }

    public int getRefondID() {
        return refondID;
    }

    public RefundState getReFundState() {
        return refundState;
    }

    public void setReFundState(RefundState refundState) {
        this.refundState = refundState;
    }

    public Refund(double amount, ServiceInfo service, int userId) {
        this.amount = amount;
        this.service = service;
        this.userId = userId;
        this.refondID = Refund.id;
        Refund.id++;
        this.refundState = RefundState.WAITING;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}

