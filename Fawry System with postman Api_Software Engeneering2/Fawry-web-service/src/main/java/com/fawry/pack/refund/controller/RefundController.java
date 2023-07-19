package com.fawry.pack.refund.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fawry.pack.refund.entity.Refund;
import com.fawry.pack.refund.handler.ReFundHandler;
import com.fawry.pack.user.handler.UserHandler;
import com.fawry.pack.user.handler.WalletHandler;
@RestController
public class RefundController {
    @Autowired
    private ReFundHandler refuFundHandler;
    @Autowired
    private UserHandler userHandler;
    @Autowired
    WalletHandler walletHandler;
    public RefundController(ReFundHandler refuFundHandler) {
        this.refuFundHandler = refuFundHandler;
    }
    @GetMapping(value = "/refunds")
    public List<Refund> getRefunds(){
        return this.refuFundHandler.getRefunds();
    }

    @PostMapping(value = "/refund/{userId}")
    public String addRefund(@RequestBody Refund refund,@PathVariable("userId")int userId) {
        if (this.userHandler.getUserById(userId) == null)
            return "user id not found";
        return this.refuFundHandler.addRefund(refund,userHandler);
    }

    @PutMapping(value = "/refund/accept/{id}/{userId}")
    public String acceptRefund(@PathVariable("id") int refundID,@PathVariable("userId")int userId) {
        if (this.userHandler.getUserById(userId) == null)
            return "user id not found";
        return this.refuFundHandler.acceptRefund(refundID,userHandler,walletHandler);
    }

    @PutMapping(value = "/refund/reject/{id}/{userId}")
    public String rejectRefund(@PathVariable("id") int refundID,@PathVariable("userId")int userId) {
        if (this.userHandler.getUserById(userId) == null)
            return "user id not found";
        return this.refuFundHandler.rejectRefund(refundID);
    }

    @GetMapping(value = "refund/trans/{userId}")
    public List<String> getRefundTransactions(@PathVariable("userId")int userId) {
        if (this.userHandler.getUserById(userId) == null)
            return null;
        return this.refuFundHandler.getRefundTransactions();
    }
    
}
