package com.fawry.pack.discount.entity;

public class OverAllDiscount extends Discount{
    public OverAllDiscount(double discountAmmount) {
        super(discountAmmount);
        this.serviceInfo.setServiceName("overAllDiscount");
    }
    
}
