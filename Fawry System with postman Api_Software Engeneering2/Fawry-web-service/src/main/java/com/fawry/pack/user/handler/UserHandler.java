package com.fawry.pack.user.handler;

import java.util.ArrayList;
import java.util.List;

import com.fawry.pack.user.entity.User;

@org.springframework.stereotype.Service
public class UserHandler {
    private List<User> myUsers;
    // private List<String> walletTrans;

    // public addWalletTrans(){
        
    // }
    // public List<String> getWalletTrans() {
    //     return walletTrans;
    // }

    public UserHandler() {
        myUsers = new ArrayList<>();
    }

    public boolean addUser(User user) {
        return this.myUsers.add(user);
    }

    public void removeUser(User user) {
        this.myUsers.remove(user);
    }

    public List<User> getUsers(){
        return this.myUsers;
    }

    public User getUserById(int userId) {
        for (User user : this.myUsers) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }
    
    public User getUserByUserName(String userName) {
        for (User user : this.myUsers) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }
        return null;
    }

    public void updateUser(User user) {
        User user1 = this.getUserById(user.getUserId());
        this.removeUser(user1);
        this.addUser(user);
    }

    
}
