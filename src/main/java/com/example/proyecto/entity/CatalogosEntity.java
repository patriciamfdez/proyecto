package com.example.proyecto.entity;

public class CatalogosEntity {

    private String tipoServicio;

    //Constructores
    public CatalogosEntity(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
    //GetterSetter

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
}
