package com.example.proyecto.dto;

public class ServicesUserDTO {
    private Integer id;
    private String username;
    private String bookingStatus;
    private String creationDate;
    private String serviceName;
    private String bookingStartDate;
    private String bookingLastDate;
    private Integer userId;
    private Integer cataloguesId;
    private Integer dogsId;

    // Getters and Setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }


    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCataloguesId() {
        return cataloguesId;
    }

    public void setCataloguesId(Integer cataloguesId) {
        this.cataloguesId = cataloguesId;
    }

    public Integer getDogsId() {
        return dogsId;
    }

    public void setDogsId(Integer dogsId) {
        this.dogsId = dogsId;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getBookingStartDate() {
        return bookingStartDate;
    }

    public void setBookingStartDate(String bookingStartDate) {
        this.bookingStartDate = bookingStartDate;
    }

    public String getBookingLastDate() {
        return bookingLastDate;
    }

    public void setBookingLastDate(String bookingLastDate) {
        this.bookingLastDate = bookingLastDate;
    }
}
