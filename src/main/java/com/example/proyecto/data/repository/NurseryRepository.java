package com.example.proyecto.data.repository;

import com.example.proyecto.data.entity.DaycareEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NurseryRepository extends CrudRepository<DaycareEntity,Long> {

    List<DaycareEntity> findAll();

    @Query(value = "SELECT * FROM guarderia WHERE precio_noche > :priceMax AND precio_noche < :priceMin", nativeQuery = true)
    List<DaycareEntity> findPriceFilter(float priceMax, float priceMin);

    List<DaycareEntity> findById();

    List<DaycareEntity> findNurseryAddress();
}

