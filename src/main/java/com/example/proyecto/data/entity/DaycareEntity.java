package com.example.proyecto.data.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "daycare")
public class DaycareEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private float night_price;
    private String phone;
    private String email;
    private String address;
    private float assessment;
    private Date entry_date;
    private Date departure_date;
    //Falta las fechas en las que se reserva

    public DaycareEntity() {
    }

    public DaycareEntity(int id, String name, float night_price, String phone, String email, String address, float assessment, Date entry_date, Date departure_date) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
