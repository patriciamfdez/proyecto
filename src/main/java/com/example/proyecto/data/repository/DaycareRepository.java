package com.example.proyecto.data.repository;

import com.example.proyecto.data.entity.Daycare;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaycareRepository extends JpaRepository<Daycare, Integer> {
    Page<Daycare> findAll(Pageable pageable);
}

