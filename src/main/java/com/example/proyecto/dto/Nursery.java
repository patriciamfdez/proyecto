package com.example.proyecto.dto;

public class Nursery {
    private String name;
    private String reservation;
    private Long id;
    private float priceNight;
    private String phone;
    private String email;
    private String adress;
    private float valoration;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getPriceNight() {
        return priceNight;
    }

    public void setPriceNight(float priceNight) {
        this.priceNight = priceNight;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public float getValoration() {
        return valoration;
    }

    public void setValoration(float valoration) {
        this.valoration = valoration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReservation() {
        return reservation;
    }

    public void setReservation(String reservation) {
        this.reservation = reservation;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    private String dateEnd;
}
