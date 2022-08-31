package com.example.proyecto.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "daycare")
public class Daycare implements Serializable {
    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false, length = 45)
    private String name;
    @Column (nullable = false)
    private float nightPrice;
    @Column(nullable = false, length = 15)
    private String phone;
    @Column(nullable = false, length = 150)
    private String email;
    @Column(nullable = false)
    private float ranking;


    // Relations

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

//    @OneToMany (mappedBy = "daycare")
//    private Set<Catalogue> catalogue;

    // Constructor
    public Daycare() {
    }

    public Daycare(Integer id, String name, float nightPrice, String phone, String email, float ranking) {
        this.id = id;
        this.name = name;
        this.nightPrice = nightPrice;
        this.phone = phone;
        this.email = email;
        this.ranking = ranking;
    }

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

    public float getNightPrice() {
        return nightPrice;
    }

    public void setNightPrice(float nightPrice) {
        this.nightPrice = nightPrice;
    }

    public float getRanking() {
        return ranking;
    }

    public void setRanking(float ranking) {
        this.ranking = ranking;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

//    public Set<Catalogue> getCatalogue() {
//        return catalogue;
//    }
//    public void setCatalogue(Set<Catalogue> catalogue) {
//        this.catalogue = catalogue;
//    }
}
