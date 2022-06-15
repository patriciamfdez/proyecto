package com.example.proyecto.entity;

public class GuarderiasEntity {

    private String nombre;
    private float precioNoche;
    private String telefono;
    private String email;
    private String direccion;
    private float valoracion;

    // Constructor

    public GuarderiasEntity(String nombre, float precioNoche, String telefono, String email, String direccion, float valoracion) {
        this.nombre = nombre;
        this.precioNoche = precioNoche;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.valoracion = valoracion;
    }

    //GetterSetter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(float precioNoche) {
        this.precioNoche = precioNoche;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }
}
