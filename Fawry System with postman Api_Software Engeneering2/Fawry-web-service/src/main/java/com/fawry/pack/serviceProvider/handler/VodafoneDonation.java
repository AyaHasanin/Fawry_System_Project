package com.fawry.pack.serviceProvider.handler;

import com.fawry.pack.service.handler.Donation;
import com.fawry.pack.service.handler.Service;
import com.fawry.pack.serviceProvider.entity.ServiceProviderInfo;
import com.fawry.pack.serviceProvider.entity.VodafoneProviderInfo;

public class VodafoneDonation implements ServiceProvider{
    private ServiceProviderInfo sProviderInfo;
    private int serviceId;
    public VodafoneDonation(/*User user*/) {
        sProviderInfo = new VodafoneProviderInfo();
        serviceId = 4;
    }
    @Override
    public Service createService() {
        return new Donation();
    }
    
    @Override
    public ServiceProviderInfo getsProviderInfo() {
        return this.sProviderInfo;
    }

    @Override
    public int getServiceId() {
        
        return this.serviceId;
    }

  
    
}
