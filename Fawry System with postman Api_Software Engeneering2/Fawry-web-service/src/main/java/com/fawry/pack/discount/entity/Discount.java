package com.fawry.pack.discount.entity;

import com.fawry.pack.service.entity.ServiceInfo;

public abstract class Discount {
    private static int id = 1;
    protected int discountId;
    protected ServiceInfo serviceInfo;
    protected double discountAmmount;

    /*
        {
            "discountAmmount":int
    
            "serviceInfo":
            {
                "serviceName":name
            }
        }
    
    */
    public int getDiscountId() {
        return discountId;
    }
 
    public ServiceInfo getServiceInfo() {
        return serviceInfo;
    }
    public void setServiceInfo(ServiceInfo serviceInfo) {
        this.serviceInfo = serviceInfo;
    }


    public Discount(double discountAmmount) {
        this.discountAmmount = discountAmmount;
        this.discountId = Discount.id;
        Discount.id++;
    }

    public double getDiscountAmmount() {
        return discountAmmount;
    }

    public void setDiscountAmmount(double discountAmmount) {
        this.discountAmmount = discountAmmount;
    }


}
