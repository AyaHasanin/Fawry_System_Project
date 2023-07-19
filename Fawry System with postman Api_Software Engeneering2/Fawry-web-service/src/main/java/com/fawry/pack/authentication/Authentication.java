package com.fawry.pack.authentication;


import com.fawry.pack.user.entity.User;
import com.fawry.pack.user.handler.UserHandler;

@org.springframework.stereotype.Service
public class Authentication {
    private UserHandler userHandler;
    public Authentication(UserHandler userHandler) {
        this.userHandler=userHandler;
    }

    public String signIn(String email, String password) {
        for (User user : userHandler.getUsers()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return (Integer.toString(user.getUserId()));
            }
        }
        return null;
    }

    public String  signUp(User user) {
        if(this.userHandler.getUserByUserName(user.getUserName()) == null)
        { 
            this.userHandler.addUser(user);
            return ("user added with username "+ user.getUserName());
        }
        else
            return  "this user name already exist";
        
    }
    
}


