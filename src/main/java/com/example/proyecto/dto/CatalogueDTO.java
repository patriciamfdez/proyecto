package com.example.proyecto.dto;

// DTO Catalogo prueba
public class CatalogueDTO {
    private Integer id;
    private String serviceType;
    private Integer daycaresId;
    private Integer dogWlakersId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Integer getDaycaresId() {
        return daycaresId;
    }

    public void setDaycaresId(Integer daycaresId) {
        this.daycaresId = daycaresId;
    }

    public Integer getDogWlakersId() {
        return dogWlakersId;
    }

    public void setDogWlakersId(Integer dogWlakersId) {
        this.dogWlakersId = dogWlakersId;
    }
}
