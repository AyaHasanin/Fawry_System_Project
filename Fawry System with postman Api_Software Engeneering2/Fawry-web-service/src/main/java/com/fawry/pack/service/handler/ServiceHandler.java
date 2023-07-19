package com.fawry.pack.service.handler;

import java.util.ArrayList;
import java.util.List;


import com.fawry.pack.service.entity.ServiceInfo;

@org.springframework.stereotype.Service
public class ServiceHandler {
    private List<Service> myServices;

    public List<Service> getMyServices() {
        return myServices;
    }

    public ServiceHandler() {
        
        this.myServices = new ArrayList<>();

        this.myServices.add(new Donation());
		this.myServices.add(new MobileRechargeService());
		this.myServices.add(new InternetPaymentService());
		this.myServices.add(new LandLineService());
    }

    public String addService(String serviceName) {
        //ServiceInfo sInfo = new ServiceInfo(serviceName);
        // if (this.myServices.add(sInfo))
        //     return "Service added";
        return "faild to add";
    }

    public String deleteService(String serviceName){
        // ServiceInfo serviceInfo = this.getServiceByName(serviceName);
        // if (serviceInfo != null) {
        //     this.myServices.remove(serviceInfo);
        //     return "Service deleted";
        // }
        return "no service found with given name";
    }

    public Service getServiceByName(String serviceName) {
        for (Service service : this.myServices) {
            if (service.getService().getServiceName().equals(serviceName))
                return service;
        }
        return null;
    }
    public Service getServiceById(int serviceId) {
        for (Service service : this.myServices) {
            if (service.getService().getServiceId() == serviceId)
                return service;
        }
        return null;
    }

    public List<ServiceInfo> searchService(String serviceName) {
        List<ServiceInfo> serviceNameMatch = new ArrayList<>();
        for (Service service : this.myServices) {
            String name = service.getService().getServiceName();
            if (name.contains(serviceName)) {
                serviceNameMatch.add(service.getService());
            }

        }
        return serviceNameMatch;
    }

    
}
