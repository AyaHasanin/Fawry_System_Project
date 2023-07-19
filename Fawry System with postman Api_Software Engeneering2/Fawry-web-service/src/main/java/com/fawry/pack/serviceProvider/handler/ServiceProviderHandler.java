package com.fawry.pack.serviceProvider.handler;


import java.util.ArrayList;
import java.util.List;

import com.fawry.pack.service.handler.ServiceHandler;

@org.springframework.stereotype.Service
public class ServiceProviderHandler { 
    private List<ServiceProvider> myServiceProviders;

    public ServiceProviderHandler() {
        this.myServiceProviders = new ArrayList<>();

        this.myServiceProviders.add(new EtisalatLandLind());
		this.myServiceProviders.add(new WeDsl());
		this.myServiceProviders.add(new VodafoneCash());
        this.myServiceProviders.add(new VodafoneDonation());
    }

    public String addServiceProvider(String sProviderName,int serviceId) {
        ServiceHandler serviceHandler=new ServiceHandler();
        if (serviceHandler.getServiceById(serviceId) != null) {
            ServiceProvider sProvider = new NewProvider(sProviderName,serviceId);
            if (this.myServiceProviders.add(sProvider))
                return "provider added";
            return "faild to add";
        }
        return "Service id not found";
    }

    public String deleteServiceProvider(String pName){
        ServiceProvider serviceProvider = this.getServiceByName(pName);
        if (serviceProvider != null) {
            this.myServiceProviders.remove(serviceProvider);
            return "Provider deleted";
        }
        return "no Provider found with given name";
    }

    public ServiceProvider getServiceByName(String serviceName) {
        for (ServiceProvider sProvider : this.myServiceProviders) {
            if (sProvider.getsProviderInfo().getProvidername().equals(serviceName))
                return sProvider;
        }
        return null;
    }

  
}
