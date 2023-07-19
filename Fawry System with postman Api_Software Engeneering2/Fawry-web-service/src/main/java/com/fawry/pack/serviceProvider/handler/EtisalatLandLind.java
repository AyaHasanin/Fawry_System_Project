package com.fawry.pack.serviceProvider.handler;


import com.fawry.pack.service.handler.LandLineService;
import com.fawry.pack.service.handler.Service;
import com.fawry.pack.serviceProvider.entity.EtisalatProviderInfo;
import com.fawry.pack.serviceProvider.entity.ServiceProviderInfo;

public class EtisalatLandLind implements ServiceProvider{
    private int serviceId;
    private ServiceProviderInfo sProviderInfo;

    public EtisalatLandLind(/*User user*/) {
        this.sProviderInfo = new EtisalatProviderInfo();// provider new 1234 // {voda}/credit/
        this.serviceId = 2;
    }
    @Override
    public Service createService() {
        return new LandLineService();
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
