package com.fawry.pack.discount.entity;

import com.fawry.pack.service.entity.ServiceInfo;

public class SpecificDiscount extends Discount {
    
    public SpecificDiscount(double discountAmmount,ServiceInfo sInfo) {
        super(discountAmmount);
        this.setServiceInfo(sInfo);
    }
    

}
