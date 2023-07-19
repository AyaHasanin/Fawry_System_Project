package com.fawry.pack.discount.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fawry.pack.discount.entity.Discount;
import com.fawry.pack.discount.entity.SpecificDiscount;
import com.fawry.pack.discount.handler.DiscountHandler;
import com.fawry.pack.user.handler.UserHandler;
@RestController
public class DiscountController {
    @Autowired
    private DiscountHandler discountHandler;
    @Autowired
    private UserHandler userHandler;

    public DiscountController(DiscountHandler discountHandler) {
        this.discountHandler = discountHandler;
    }

    @GetMapping(value = "/discounts")
    public List<Discount> getDiscounts() {
        return this.discountHandler.getDiscounts();
    }
    
    @GetMapping(value = "/discount/{serviceName}/{userId}")
    public List<Discount> getAvailableDiscounts(@PathVariable("serviceName") String serviceName, @PathVariable("userId") int userId) {
        if (this.userHandler.getUserById(userId) == null)
            return null;
        return this.discountHandler.availableDiscount(serviceName);
    }

    @PostMapping(value = "/discount/{userId}")
    public String addDiscount(@RequestBody SpecificDiscount discount, @PathVariable("userId") int userId) {
        if (this.userHandler.getUserById(userId) == null)
            return "user id not found";
        return this.discountHandler.addDiscount(discount);
    }

    @DeleteMapping(value = "/discount/{id}/{userId}")
    public String deleteDiscount(@PathVariable("id") int discountId, @PathVariable("userId") int userId) {
        if (this.userHandler.getUserById(userId) == null)
            return "user id not found";
        return this.discountHandler.deleteDiscount(discountId);
    }
}
