package com.example.proyecto.data.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "paymentMethod")
public class PaymentMethodEntity implements Serializable {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public void setDescripcion(String description) {
        this.description = description;
    }
}
