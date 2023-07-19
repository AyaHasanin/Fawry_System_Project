package com.fawry.pack.service.entity;



public class ServiceInfo {
    protected String serviceName;
    protected int serviceId;
    private static int id = 5;

    public String toString() {
        String str = ("\nserviceName = " + this.serviceName);
        str += ("\nserviceId = " + this.serviceId);
        return str;
    }
    
    public ServiceInfo() {
    }

    public ServiceInfo(String serviceName) {
        this.serviceName = serviceName;
        serviceId = ServiceInfo.id;
        ServiceInfo.id++;
    }
    /*
     
        {
           "serviceName":"se",
           "serviceId":1
        }
     */

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }


    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    // public abstract void paymentAction(double ammount);

    // public double discountAction(double ammount) {
    //     // DiscountHandler discountHandler = new DiscountHandler();
    //     // Discount discount = discountHandler.availableDiscount(ServiceName);
    //     // if (discount != null) {
    //     //     ammount = discount.applyDiscount(ammount);
    //     // }
    //      return ammount;
    // }
    // public final void performPayment(double ammount) {
    //     ammount = discountAction(ammount);
    //     paymentAction(ammount);
    // }
}
