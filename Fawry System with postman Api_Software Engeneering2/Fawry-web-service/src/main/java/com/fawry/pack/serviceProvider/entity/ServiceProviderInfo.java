package com.fawry.pack.serviceProvider.entity;
public abstract class ServiceProviderInfo {
    private String providername;
    private int providerId;
    private static int id = 1;

    public ServiceProviderInfo() {
        this.providerId = ServiceProviderInfo.id;
        ServiceProviderInfo.id++;
    }
    public String getProvidername() {
        return providername;
    }
    public void setProvidername(String providername) {
        this.providername = providername;
    }
    public int getProviderId() {
        return providerId;
    }
    
}
