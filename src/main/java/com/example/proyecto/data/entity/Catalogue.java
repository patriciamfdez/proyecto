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
    private DaycareEntity daycare;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private DogWalkerEntity dogWalker;

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

    public DaycareEntity getDaycare() {
        return daycare;
    }

    public void setDaycare(DaycareEntity daycare) {
        this.daycare = daycare;
    }

    public DogWalkerEntity getDogWalker() {
        return dogWalker;
    }

    public void setDogWalker(DogWalkerEntity dogWalker) {
        this.dogWalker = dogWalker;
    }
}
