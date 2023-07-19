package com.fawry.pack.serviceProvider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fawry.pack.serviceProvider.handler.ServiceProviderHandler;
import com.fawry.pack.user.handler.UserHandler;
@RestController
public class ServiceProviderController {
    @Autowired
    ServiceProviderHandler serviceProviderHandler;
    @Autowired
    private UserHandler userHandler;
    public ServiceProviderController(ServiceProviderHandler serviceProviderHandler) {
        this.serviceProviderHandler = serviceProviderHandler;
    }
    
    @PostMapping(value = "/provider/{name}/{sId}/{userId}") //(value = "/service/{name}")
    public String addServiceProviderInfo(@PathVariable("name") String providerName,@PathVariable("sId") int serviceId,
    @PathVariable("userId")int userId) {
        if (this.userHandler.getUserById(userId) == null)
            return "user id not found";
        return this.serviceProviderHandler.addServiceProvider(providerName,serviceId);
    }

    @DeleteMapping(value = "/provider/{name}/{userId}")
    public String deleteServiceProviderInfo(@PathVariable("name") String serviceName,@PathVariable("userId")int userId) {
        if (this.userHandler.getUserById(userId) == null)
            return "user id not found";

        return this.serviceProviderHandler.deleteServiceProvider(serviceName);
    }
}
