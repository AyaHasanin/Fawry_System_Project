package com.fawry.pack.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fawry.pack.user.handler.UserHandler;
import com.fawry.pack.user.handler.WalletHandler;

@RestController
public class WalletController {
    @Autowired
    private WalletHandler walletHandler;
    @Autowired
    private UserHandler userHandler;

    @GetMapping(value = "/wallet/trans/{userId}")
    public List<String> getWalletTransaction(@PathVariable("userId")int userId) {
        if (this.userHandler.getUserById(userId) == null)
            return null;
        return this.walletHandler.getWalletTrans();
    }
}
