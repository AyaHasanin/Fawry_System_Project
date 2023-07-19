package com.fawry.pack.user.handler;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fawry.pack.user.entity.Wallet;
@Service
public class WalletHandler {
    private Wallet wallet;

    private List<String> walletTrans;

    public List<String> getWalletTrans() {
        return walletTrans;
    }

    public WalletHandler(Wallet wallet) {
        this.wallet = wallet;
        this.walletTrans=new ArrayList<>();
    }

    public WalletHandler() {
        this.walletTrans=new ArrayList<>();
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
    public void addFund(double fund,int userId) {
        this.wallet.setMoney(this.wallet.getMoney() + fund);
        this.walletTrans.add(this.addTrans(fund, userId));
    }

    private String addTrans(double ammount, int userId) {
        String str = ("user with id = " + userId + " add "+ammount+" $ to his wallet at date and time : " + LocalDateTime.now().toString());
        return str;
    }
    
    public boolean reduceMoney(double ammount) {
        if(this.wallet.getMoney() >= ammount)
        {
            this.wallet.setMoney(this.wallet.getMoney() - ammount);
            return true;
        }
        return false;
    }
    
}
