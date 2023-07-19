package com.fawry.pack.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fawry.pack.service.entity.ServiceInfo;
import com.fawry.pack.service.handler.ServiceHandler;
import com.fawry.pack.user.handler.UserHandler;

@RestController
public class ServiceController {
    @Autowired
    private ServiceHandler serviceHandler;
    @Autowired
    private UserHandler userHandler;
    public ServiceController(ServiceHandler serviceHandler) {
        this.serviceHandler = serviceHandler;
    }

    @GetMapping(value = "/service/{serviceName}/{userId}")
    public List<ServiceInfo> searchForService(@PathVariable("serviceName") String serviceName,@PathVariable("userId")int userId) {
        if (this.userHandler.getUserById(userId) == null)
            return null;
        return this.serviceHandler.searchService(serviceName);
    }

    @PostMapping(value = "/service/{name}/{userId}")
    public String addServiceInfo(@PathVariable("name") String serviceInfo,@PathVariable("userId")int userId) {
        if (this.userHandler.getUserById(userId) == null)
            return "user id not found";
        return this.serviceHandler.addService(serviceInfo);
    }

    @DeleteMapping(value = "/service/{name}/{userId}")
    public String removeServiceInfo(@PathVariable("name") String serviceName,@PathVariable("userId")int userId) {
        if (this.userHandler.getUserById(userId) == null)
            return "user id not found";
        return this.serviceHandler.deleteService(serviceName);
    }
    
}
