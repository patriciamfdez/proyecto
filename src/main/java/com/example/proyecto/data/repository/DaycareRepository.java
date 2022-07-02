package com.example.proyecto.data.repository;

import com.example.proyecto.data.entity.DaycareEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DaycareRepository extends CrudRepository<DaycareEntity,Long> {

    List<DaycareEntity> findAll();

    @Query(value = "SELECT * FROM daycare WHERE price_night > :priceMax AND price_night < :priceMin", nativeQuery = true)
    List<DaycareEntity> findPriceFilter(float priceMax, float priceMin);

   // List<DaycareEntity> findById();

   // List<DaycareEntity> findNurseryAddress();
}

