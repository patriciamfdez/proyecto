package com.example.proyecto.data.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Catalogue implements Serializable {


    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 45)
    private String serviceType;

    // Relations

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private DaycareEntity daycares;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private DogWalkerEntity dogWalkers;

    //Constructores

    public Catalogue(Integer id, String serviceType) {
        this.id = id;
        this.serviceType = serviceType;
    }


    //GetterSetter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public DaycareEntity getDaycares() {
        return daycares;
    }

    public void setDaycares(DaycareEntity daycares) {
        this.daycares = daycares;
    }

    public DogWalkerEntity getDogWalkers() {
        return dogWalkers;
    }

    public void setDogWalkers(DogWalkerEntity dogWalkers) {
        this.dogWalkers = dogWalkers;
    }
}
