package com.fawry.pack.authentication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fawry.pack.user.entity.Customer;

@RestController
public class AuthenticationController {
    private Authentication authenticator;

    public AuthenticationController(Authentication authenticator) {
        this.authenticator = authenticator;
    }


    @GetMapping(value = "/sign-in/{email}/{password}")
    public String signIn(@PathVariable("email") String email,@PathVariable("password") String password) {
        String id = this.authenticator.signIn(email, password);
        if (id == null) {
            return "is not exist";
        }
        return "user id = "+id;
    }

    
    @PostMapping(value = "/rejester")
    public String rejester(@RequestBody Customer user) {
        
        return this.authenticator.signUp(user);
 
    }

    /* 
        {
            "userName":"aya",
            "password":"0123",
            "email":"aya@gmail",
            "Wallet":{
                "money":0
            }
        }
    */
}
