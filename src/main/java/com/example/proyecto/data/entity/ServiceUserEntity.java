package com.example.proyecto.data.entity;

import javax.persistence.Entity;


import java.util.Date;
@Entity
public class ServiceUserEntity {
    private Integer id;
    private String username;
    private String BookingStatus;
    private Date CreationDate;
    private String ServiceName;
    private Date BookingStartDate;
    private Date BookingLastDate;

    // Constructores

    public ServiceUserEntity(Integer id, String username, String BookingStatus, Date CreationDate, String ServiceName, Date BookingStartDate, Date BookingLastDate) {
        this.id = id;
        this.username = username;
        this.BookingStatus = BookingStatus;
        this.CreationDate = CreationDate;
        this.ServiceName = ServiceName;
        this.BookingStartDate = BookingStartDate;
        this.BookingLastDate = BookingLastDate;
    }


    // Getter and Setters


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
        return BookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.BookingStatus = bookingStatus;
    }

    public Date getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.CreationDate = creationDate;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String serviceName) {
        this.ServiceName = serviceName;
    }

    public Date getBookingStartDate() {
        return BookingStartDate;
    }

    public void setBookingStartDate(Date bookingStartDate) {
        this.BookingStartDate = bookingStartDate;
    }

    public Date getBookingLastDate() {
        return BookingLastDate;
    }

    public void setBookingLastDate(Date bookingLastDate) {
        this.BookingLastDate = bookingLastDate;
    }
}
