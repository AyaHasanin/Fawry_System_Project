package com.fawry.pack.serviceProvider.handler;

import com.fawry.pack.service.handler.InternetPaymentService;
import com.fawry.pack.service.handler.Service;
import com.fawry.pack.serviceProvider.entity.ServiceProviderInfo;
import com.fawry.pack.serviceProvider.entity.WeProviderInfo;

public class WeDsl implements ServiceProvider{
    private ServiceProviderInfo weProviderInfo;

    private int serviceId;

    public WeDsl() {
        this.weProviderInfo = new WeProviderInfo();
        this.serviceId = 2;
    }

    @Override
    public Service createService() {
        return new InternetPaymentService();
    }

    @Override
    public ServiceProviderInfo getsProviderInfo() {
        return this.weProviderInfo;
    }

    @Override
    public int getServiceId() {
        return this.serviceId;
    }
    
}
