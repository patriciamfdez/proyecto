package com.example.proyecto.data.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "daycare")
public class DaycareEntity  implements Serializable {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, length = 45)
    private String name;
    @Column(nullable = false)
    private float night_price;
    @Column(nullable = false, length = 15)
    private String phone;
    @Column(nullable = false, length = 150)
    private String email;
    @Column(nullable = false, length = 150)
    private String address;
    private float assessment;


    // Relations

    @ManyToMany (fetch = FetchType.EAGER)
    private Set<AddressEntity> addresses;

    // Constructor

    public DaycareEntity() {
    }

    public DaycareEntity(Integer id, String name, float night_price, String phone, String email, String address, float assessment, Date entry_date, Date departure_date) {
        this.id = id;
        this.name = name;
        this.night_price = night_price;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.assessment = assessment;
        this.entry_date = entry_date;
        this.departure_date = departure_date;
    }

    // Getters and Setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getNight_price() {
        return night_price;
    }

    public void setNight_price(float night_price) {
        this.night_price = night_price;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getAssessment() {
        return assessment;
    }

    public void setAssessment(float assessment) {
        this.assessment = assessment;
    }

    public Date getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(Date entry_date) {
        this.entry_date = entry_date;
    }

    public Date getDeparture_date() {
        return departure_date;
    }

    public void setDeparture_date(Date departure_date) {
        this.departure_date = departure_date;
    }

    public Set<AddressEntity> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<AddressEntity> addresses) {
        this.addresses = addresses;
    }
}
