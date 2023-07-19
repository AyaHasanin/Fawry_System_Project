package com.fawry.pack.refund.handler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fawry.pack.refund.entity.Refund;
import com.fawry.pack.refund.entity.RefundState;
import com.fawry.pack.user.entity.Customer;
import com.fawry.pack.user.handler.UserHandler;
import com.fawry.pack.user.handler.WalletHandler;

@Service
public class ReFundHandler{
	private List<Refund> refunds;
	private List<String> refudnTransaction;


    public ReFundHandler() {
        this.refunds = new ArrayList<>();
		this.refudnTransaction = new ArrayList<>();

    }

    public List<Refund> getRefunds() {
        return this.refunds;
    }
    
    public String addRefund(Refund refund,UserHandler userHandler) {
        if (userHandler.getUserById(refund.getUserId()) == null)
            return "user id not correct";
        if (this.refunds.add(refund)) {
            this.refudnTransaction.add(addTransaction(refund));// add transaction
            return "refund added with id = "+refund.getRefondID();
        } 
        else 
            return "faild to add refund";
    }

    public boolean removeRefund(int refundId) {
        Refund refund = this.getRefundById(refundId);
        return this.refunds.remove(refund);
    }

    private Refund getRefundById(int id) {
        for (Refund refund : this.refunds) {
            if (refund.getRefondID() == id) {
                return refund;
            }
        }
        return null;
    }
    
    public String acceptRefund(int refundID,UserHandler userHandler,WalletHandler walletHandler) {
        Refund refund = this.getRefundById(refundID);
        if (refund == null) {
            return  "no refund found";
        }
        if (refund.getReFundState() != RefundState.ACCEPTED) { // unit test
            Customer user = (Customer) userHandler.getUserById(refund.getUserId());
            walletHandler.setWallet(user.getWallet());
            walletHandler.addFund(refund.getAmount(),user.getUserId());
            refund.setReFundState(RefundState.ACCEPTED);
            this.refudnTransaction.add("accept refund " + this.toString(refund));
            return "refund has been accepted " +
            this.notifyUser(user.getEmail(), RefundState.ACCEPTED.toString());
        }
        return " this refund has been allready accepted";
    }

    public String rejectRefund(int refundID) {
        Refund refund = this.getRefundById(refundID);
        refund.setReFundState(RefundState.REJECTED);
        UserHandler userHandler = new UserHandler();
        String email = userHandler.getUserById(refund.getUserId()).getEmail();
        this.notifyUser(email, RefundState.REJECTED.toString());
        this.refudnTransaction.add("reject refund " + this.toString(refund));
        return "refund has been rejected";
    }
    
    private String notifyUser(String email, String state) {
        String message = "your refund has been " + state + ((state == "accepted") ? " check your wallet" : "(-_-)!");
        EmailSender emailSender = new EmailSender();
        return emailSender.sendMail(email, message);
    }

    private String addTransaction(Refund refund) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String trans = this.toString(refund);
        return trans + "\n" +localDateTime.toString();
    }

    public List<String> getRefundTransactions() {
        return this.refudnTransaction;
    }
    
    private String toString(Refund refund) {
        String ref = "";
        ref += ("refund ammount = " + refund.getAmount());
        ref += ("\nrefondID = " + refund.getRefondID());
        ref += (refund.getService().toString());
        ref += ("\nuser id = " + refund.getUserId());
        return ref;
    }
    
    // public void checkRefunds() {
    //     UserInterface UI = new UserInterface();
    //     for (Observer observer : this.observers) {
    //         Refund refund = (Refund) observer;
    //         UI.printRefund(refund);
    //         if (UI.acceptRefund()) {
    //             refund.setReFundState("accepted");
    //         }
    //         else {
    //             refund.setReFundState("rejected");
    //         }
    //     }
    // }
    
}
