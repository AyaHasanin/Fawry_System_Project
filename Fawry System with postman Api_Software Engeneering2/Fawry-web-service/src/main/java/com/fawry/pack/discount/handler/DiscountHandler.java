package com.fawry.pack.discount.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fawry.pack.discount.entity.Discount;

@Service
public class DiscountHandler {
        private List<Discount> discountList;

    public DiscountHandler() {
        this.discountList = new ArrayList<>();
    }
    public List<Discount> getDiscounts() {
        return this.discountList;
    }

    public String addDiscount(Discount discount) {
        if(this.discountList.add(discount))
            return "discount added with id = "+discount.getDiscountId();
        return "faild to add";
    }
    
    public List<Discount> availableDiscount(String serviceName) {
        List<Discount> avalDiscounts = new ArrayList<>();
        for (Discount discount : this.discountList) {
            if (discount.getServiceInfo().getServiceName().equals(serviceName)) {
                avalDiscounts.add(discount);
            }
        }
        return avalDiscounts;

    }

    public String deleteDiscount(int discountId) {
        for (Discount discount : this.discountList) {
            if (discount.getDiscountId() == discountId) {
                this.discountList.remove(discount);
                return "discount removed";
            }
        }
        return ("no discount found with id = " + discountId);
    }
  
    public double applyDiscount(double ammountBeforeDiscount,Discount discount) {
        double reduce = ((ammountBeforeDiscount * discount.getDiscountAmmount()) / 100);
        return ammountBeforeDiscount - reduce;
    }
}
