package com.example.proyecto.data.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "catalogue")

public class CatalogueEntity {

    private String serviceType;


    //Constructores
    public CatalogueEntity(String serviceType) {
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
