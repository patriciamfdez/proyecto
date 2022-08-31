package com.example.proyecto.data.entity;

import javax.persistence.*;
import java.io.Serializable;
//@NamedNativeQueries({                                         este me pide SessionFactory
//        @NamedNativeQuery(
//                name = "callAltaCatalogo",
//                query = "CALL alta_catalogo()",
//                resultClass = Catalogue.class)
//})
@NamedStoredProcedureQueries({                                      // usando  @NamedStoredProcedureQuery
        @NamedStoredProcedureQuery(
                name = "AltaCatalogo",
                procedureName = "doggo.alta_catalogo"
                )
})



@Entity
public class Catalogue implements Serializable {


    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 45)
    private String serviceType;

    @Column(nullable = false)
    private Integer id_product;

    @Column(nullable = false)
    private String serviceDescription;


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
