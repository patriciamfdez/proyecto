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
    private Daycare daycares;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private DogWalker dogWalkers;

    //Constructores


    public Catalogue() {
    }

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

    public Daycare getDaycares() {
        return daycares;
    }

    public void setDaycares(Daycare daycares) {
        this.daycares = daycares;
    }

    public DogWalker getDogWalkers() {
        return dogWalkers;
    }

    public void setDogWalkers(DogWalker dogWalkers) {
        this.dogWalkers = dogWalkers;
    }


}
