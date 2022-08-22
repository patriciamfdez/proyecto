package com.example.proyecto.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "dog")
public class Dog implements Serializable {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 45)
    private String name;
    @Column(nullable = false)
    private float weightKg;
    @Column(nullable = false, length = 150)
    private String age;
    @Column(nullable = false, length = 10)
    private String gender;
    @Column(nullable = false, length = 45)
    private String race;
    @Column(nullable = false)
    private String microchip;
    @Column(nullable = false)
    private String sterilized;
    @Column(length = 400)
    private String infAdditional;
    @Column(nullable = false)
    private String compatible; // Este atributo identifica si el perro puede pasear con otros perros (true) o si tiene que pasear solo (false)
    @Column(length = 512)
    private String allergies;

    // Relations

    @OneToMany (mappedBy = "dog")
    private Set<User> user;

    // Builder


    public Dog() {
    }

    public Dog(Integer id, String name, float weightKg, String age, String gender, String race, String microchip, String sterilized, String infAdditional, String compatible, String allergies) {
        this.id = id;
        this.name = name;
        this.weightKg = weightKg;
        this.age = age;
        this.gender = gender;
        this.race = race;
        this.microchip = microchip;
        this.sterilized = sterilized;
        this.infAdditional = this.infAdditional;
        this.compatible = compatible;
        this.allergies = allergies;
    }

    //Getters y Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(float weightKg) {
        this.weightKg = weightKg;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getMicrochip() {
        return microchip;
    }

    public void setMicrochip(String microchip) {
        this.microchip = microchip;
    }

    public String getSterilized() {
        return sterilized;
    }

    public void setSterilized(String sterilized) {
        this.sterilized = sterilized;
    }

    public String getInfAdditional() {
        return infAdditional;
    }

    public void setInfAdditional(String infAdditional) {
        this.infAdditional = infAdditional;
    }

    public String getCompatible() {
        return compatible;
    }

    public void setCompatible(String compatible) {
        this.compatible = compatible;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }
}
