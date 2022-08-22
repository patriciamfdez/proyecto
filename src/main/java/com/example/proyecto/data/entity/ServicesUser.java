package com.example.proyecto.data.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Table(name = "servicesUser")
public class ServicesUser implements Serializable {

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 45)
    private String username;
    @Column(nullable = false, length = 100)
    private String bookingStatus;
    @Column(nullable = false)
    private ZonedDateTime creationDate;
    @Column(nullable = false, length = 45)
    private String serviceName;
    @Column(nullable = false)
    private ZonedDateTime bookingStartDate;
    @Column(nullable = false)
    private ZonedDateTime bookingLastDate;

    // Relations

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User users;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Catalogue catalogues;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Dog dogs;

    // Constructores

    public ServicesUser() {
    }

    public ServicesUser(Integer id, String username, String bookingStatus, ZonedDateTime creationDate, String serviceName, ZonedDateTime bookingStartDate, ZonedDateTime bookingLastDate, User users, Catalogue catalogues, Dog dogs) {
        this.id = id;
        this.username = username;
        this.bookingStatus = bookingStatus;
        this.creationDate = creationDate;
        this.serviceName = serviceName;
        this.bookingStartDate = bookingStartDate;
        this.bookingLastDate = bookingLastDate;
        this.users = users;
        this.catalogues = catalogues;
        this.dogs = dogs;
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
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(ZonedDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public ZonedDateTime getBookingStartDate() {
        return bookingStartDate;
    }

    public void setBookingStartDate(ZonedDateTime bookingStartDate) {
        this.bookingStartDate = bookingStartDate;
    }

    public ZonedDateTime getBookingLastDate() {
        return bookingLastDate;
    }

    public void setBookingLastDate(ZonedDateTime bookingLastDate) {
        this.bookingLastDate = bookingLastDate;
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Catalogue getCatalogues() {
        return catalogues;
    }

    public void setCatalogues(Catalogue catalogues) {
        this.catalogues = catalogues;
    }

    public Dog getDogs() {
        return dogs;
    }

    public void setDogs(Dog dogs) {
        this.dogs = dogs;
    }
}
