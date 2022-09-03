package com.example.proyecto.data.repository;

import com.example.proyecto.data.entity.Catalogue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CatalogueRepository extends JpaRepository<Catalogue, Integer> {
    Page<Catalogue> findByServiceType(String serviceType, Pageable pageable);
    Page<Catalogue> findAll( Pageable pageable);

}
