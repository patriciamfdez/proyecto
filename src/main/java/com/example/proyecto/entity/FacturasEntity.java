package com.example.proyecto.entity;
import java.util.Date;

public class FacturasEntity {

    private Date fechaCreacion;
    private float totalPago;
    private String estadoPago;

    //Constructor

    public FacturasEntity(Date fechaCreacion, float totalPago, String estadoPago) {
        this.fechaCreacion = fechaCreacion;
        this.totalPago = totalPago;
        this.estadoPago = estadoPago;
    }

    //GetterSetter


    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public float getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(float totalPago) {
        this.totalPago = totalPago;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }
}
