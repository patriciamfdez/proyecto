package com.example.proyecto.data.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class AddressEntity implements Serializable {
    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 45)
    private String country;
    @Column(nullable = false, length = 45)
    private String province;
    @Column(nullable = false, length = 45)
    private String city;
    @Column(nullable = false, length = 45)
    private String postalCode;
    @Column(nullable = false, length = 200)
    private String address;

    //Relations
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private DaycareEntity daycare;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private DogWalkerEntity dogWalker;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;

    //Constructores
    public AddressEntity(Integer id, String country, String province, String city, String postalCode, String address) {
        this.id = id;
        this.country = country;
        this.province = province;
        this.city = city;
        this.postalCode = postalCode;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    //Getter and Setter
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
