package com.example.proyecto.data.repository;

import com.example.proyecto.data.entity.Catalogue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;


public interface CatalogueRepository extends JpaRepository<Catalogue, Integer> {
    Page<Catalogue> findByServiceType(String serviceType, Pageable pageable);
    Page<Catalogue> findAll( Pageable pageable);

//    @Query(value = "call alta_catalogo()", nativeQuery = true)
//    void altaCatalogo();

    @Procedure(name = "AltaCatalogo")          // usando  @NamedStoredProcedureQuery
    String altaCatalogo();



    /*

    En teoría no devuelve nada, por eso es un void. PERO me da error, dice que no puede convertir el tipo String en el tipo requerido (Integer)
    donde está ese integer?
    El úinico sitio donde escribo un String es en el controlador, pero ahí es tipo String porque devuelve una dirección (url)

Failed to convert value of type 'java.lang.String' to required type 'java.lang.Integer'; nested exception is java.lang.NumberFormatException:
For input string: "alta" org.springframework.web.method.annotation.MethodArgumentTypeMismatchException:
Failed to convert value of type 'java.lang.String' to required type 'java.lang.Integer';
 nested exception is java.lang.NumberFormatException: For input string: "alta"

     */
}
