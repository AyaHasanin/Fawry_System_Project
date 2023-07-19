package com.fawry.pack.serviceProvider.handler;

import com.fawry.pack.service.handler.Service;
import com.fawry.pack.serviceProvider.entity.NewServiceProviderInfo;
import com.fawry.pack.serviceProvider.entity.ServiceProviderInfo;

public class NewProvider implements ServiceProvider{
    private int serviceId;

    private ServiceProviderInfo serviceProviderInfo;

    public NewProvider(String providerName, int serviceId) {
        this.serviceProviderInfo = new NewServiceProviderInfo(providerName);
        this.serviceId = serviceId;
    }

    @Override
    public Service createService() {

        return null;
    }

    @Override
    public ServiceProviderInfo getsProviderInfo() {
        return this.serviceProviderInfo;
    }

    @Override
    public int getServiceId() {
        return this.serviceId;
    }
    
}
