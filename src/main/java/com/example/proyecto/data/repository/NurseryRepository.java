package com.example.proyecto.data.repository;

import com.example.proyecto.data.entity.NurseryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NurseryRepository extends CrudRepository<NurseryEntity,Long> {

    List<NurseryEntity> findAll();

    @Query(value = "SELECT * FROM guarderia WHERE precio_noche > :priceMax AND precio_noche < :priceMin", nativeQuery = true)
    List<NurseryEntity> findPriceFilter(float priceMax, float priceMin);
}
