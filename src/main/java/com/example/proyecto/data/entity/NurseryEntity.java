package com.example.proyecto.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "guarderia")
public class NurseryEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String nombre;
    private float precio_noche;
    private String telefono;
    private String email;
    private String direccion;
    private float valoracion;

    public NurseryEntity() {}

    public NurseryEntity(long id, String nombre, float precio_noche, String telefono, String email, String direccion, float valoracion) {
        this.id = id;
        this.nombre = nombre;
        this.precio_noche = precio_noche;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.valoracion = valoracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio_noche() {
        return precio_noche;
    }

    public void setPrecioNoche(float precioNoche) {
        this.precio_noche = precioNoche;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPrecio_noche(float precio_noche) {
        this.precio_noche = precio_noche;
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
