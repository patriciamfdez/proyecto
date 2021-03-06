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
    private boolean microchip;
    @Column(nullable = false)
    private boolean sterilized;
    @Column(length = 400)
    private String infAdditional;
    @Column(nullable = false)
    private boolean compatible; // Este atributo identifica si el perro puede pasear con otros perros (true) o si tiene que pasear solo (false)
    @Column(length = 512)
    private String allergies;

    // Relations

    @OneToMany (mappedBy = "dog")
    private Set<User> user;

    // Builder


    public Dog() {
    }

    public Dog(Integer id, String name, float weightKg, String age, String gender, String race, boolean microchip, boolean sterilized, String infAdditional, boolean compatible, String allergies) {
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

    public boolean isMicrochip() {
        return microchip;
    }

    public void setMicrochip(boolean microchip) {
        this.microchip = microchip;
    }

    public boolean isSterilized() {
        return sterilized;
    }

    public void setSterilized(boolean esterilizado) {
        this.sterilized = sterilized;
    }

    public String getInfAdditional() {
        return infAdditional;
    }

    public void setInfAdditional(String infAdditional) {
        this.infAdditional = infAdditional;
    }

    public boolean isCompatible() {
        return compatible;
    }

    public void setCompatible(boolean compatible) {
        this.compatible = compatible;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }
}
