package com.fawry.pack.serviceProvider.handler;


import com.fawry.pack.service.handler.Service;
import com.fawry.pack.serviceProvider.entity.ServiceProviderInfo;

public interface ServiceProvider {
    
    public Service createService();
    public ServiceProviderInfo getsProviderInfo();
    public int getServiceId();
}
