package com.fawry.pack.serviceProvider.handler;

import com.fawry.pack.service.handler.MobileRechargeService;
import com.fawry.pack.service.handler.Service;
import com.fawry.pack.serviceProvider.entity.ServiceProviderInfo;
import com.fawry.pack.serviceProvider.entity.VodafoneProviderInfo;

public class VodafoneCash implements ServiceProvider {
    private ServiceProviderInfo sProviderInfo;
    private int serviceId;
    @Override
    public ServiceProviderInfo getsProviderInfo() {
        return sProviderInfo;
    }

    public void setsProviderInfo(ServiceProviderInfo sProviderInfo) {
        this.sProviderInfo = sProviderInfo;
    }

    @Override
    public Service createService() {
        return new MobileRechargeService();
    }

    public VodafoneCash() {
        this.sProviderInfo = new VodafoneProviderInfo();
        this.serviceId = 1;

    }

    @Override
    public int getServiceId() {
        
        return this.serviceId;
    }



    
}
