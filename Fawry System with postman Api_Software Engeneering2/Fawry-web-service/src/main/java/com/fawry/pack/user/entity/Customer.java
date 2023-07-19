package com.fawry.pack.user.entity;

public class Customer extends User{

    Wallet wallet;

    public Customer() {
    }

    public Customer(String userName, String password, String email, Wallet wallet) {
        super(userName, password, email);
        this.wallet = wallet;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }


}
