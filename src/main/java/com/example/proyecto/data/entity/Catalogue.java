package com.example.proyecto.data.entity;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "catalogue")
@NamedStoredProcedureQuery(name = "ActualizarCatalogo", procedureName = "altacatalogo",resultClasses = {
        Catalogue.class }
)
@NamedStoredProcedureQuery(name = "BorradoLogicoCatalogo", procedureName = "borradologicocatalogo",resultClasses = {
        Catalogue.class }, parameters = {
        @StoredProcedureParameter(name = "id_product", type = Integer.class, mode = ParameterMode.IN),
        @StoredProcedureParameter(name = "serviceType", type = String.class, mode = ParameterMode.IN)}
)
@NamedStoredProcedureQuery(name = "RestauragoLogicoCatalogo", procedureName = "restauradologicocatalogo",resultClasses = {
        Catalogue.class }, parameters = {
        @StoredProcedureParameter(name = "id_product", type = Integer.class, mode = ParameterMode.IN),
        @StoredProcedureParameter(name = "serviceType", type = String.class, mode = ParameterMode.IN)
}
)
public class Catalogue implements Serializable {


    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 45,name = "service_type")
    private String serviceType;

    @Column(nullable = false,name = "id_product")
    private Integer id_product;

    @Column(nullable = false)
    private String serviceDescription;

    @Column(nullable = false, columnDefinition = "integer default 1")
    private Integer active;
    //Constructores


    public Catalogue() {
    }

    public Catalogue(Integer id, String serviceType, Integer id_product, String serviceDescription) {
        this.id = id;
        this.serviceType = serviceType;
        this.id_product = id_product;
        this.serviceDescription = serviceDescription;
    }

    //GetterSetter


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

    public Integer getId_product() {
        return id_product;
    }

    public void setId_product(Integer id_product) {
        this.id_product = id_product;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }
}
