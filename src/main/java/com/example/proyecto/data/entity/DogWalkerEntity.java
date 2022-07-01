package com.example.proyecto.data.entity;

import java.util.Date;

public class DogWalkerEntity {
    private String doc_identification;
    private String name;
    private String first_surname;
    private String last_surname;
    private String email;
    private String password;
    private String phone;
    private Date birthdate;
    private String availability;
    private String address;
    private Integer max_num_dogs;
    private String weight_dogs;
    private boolean sterilized;
    private String reviews;
    private float assessment;
    private float price_walk;
    // Duda de como poner las fotos
    private String profile_picture;
    private String gallery;

    // Constructor

    public DogWalkerEntity(String doc_identification, String name, String first_surname, String last_surname, String email, String password, String phone, Date birthdate, String availability, String address, Integer max_num_dogs, String weight_dogs, boolean sterilized, String reviews, float assessment, float price_walk, String profile_picture, String gallery) {
        this.doc_identification = doc_identification;
        this.name = name;
        this.first_surname = first_surname;
        this.last_surname = last_surname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.birthdate = birthdate;
        this.availability = availability;
        this.address = address;
        this.max_num_dogs = max_num_dogs;
        this.weight_dogs = weight_dogs;
        this.sterilized = sterilized;
        this.reviews = reviews;
        this.assessment = assessment;
        this.price_walk = price_walk;
        this.profile_picture = profile_picture;
        this.gallery = gallery;
    }

    public String getDoc_identification() {
        return doc_identification;
    }

    public void setDoc_identification(String doc_identification) {
        this.doc_identification = doc_identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_surname() {
        return first_surname;
    }

    public void setFirst_surname(String first_surname) {
        this.first_surname = first_surname;
    }

    public String getLast_surname() {
        return last_surname;
    }

    public void setLast_surname(String last_surname) {
        this.last_surname = last_surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getMax_num_dogs() {
        return max_num_dogs;
    }

    public void setMax_num_dogs(Integer max_num_dogs) {
        this.max_num_dogs = max_num_dogs;
    }

    public String getWeight_dogs() {
        return weight_dogs;
    }

    public void setWeight_dogs(String weight_dogs) {
        this.weight_dogs = weight_dogs;
    }

    public boolean isSterilized() {
        return sterilized;
    }

    public void setSterilized(boolean sterilized) {
        this.sterilized = sterilized;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }

    public float getAssessment() {
        return assessment;
    }

    public void setAssessment(float assessment) {
        this.assessment = assessment;
    }

    public float getPrice_walk() {
        return price_walk;
    }

    public void setPrice_walk(float price_walk) {
        this.price_walk = price_walk;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public String getGallery() {
        return gallery;
    }

    public void setGallery(String gallery) {
        this.gallery = gallery;
    }
}