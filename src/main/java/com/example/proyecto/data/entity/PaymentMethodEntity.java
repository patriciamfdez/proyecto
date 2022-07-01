package com.example.proyecto.data.entity;

public class PaymentMethodEntity {
    private Integer id;
    private String description;

    //Constructores

    public PaymentMethodEntity(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    //Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
