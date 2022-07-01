package com.example.proyecto.data.entity;

public class CatalogeEntity {

    private String serviceType;


    //Constructores
    public CatalogeEntity(String serviceType) {
        this.serviceType = serviceType;
    }

    //GetterSetter
    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
}
