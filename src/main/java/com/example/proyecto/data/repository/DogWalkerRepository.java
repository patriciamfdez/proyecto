package com.example.proyecto.data.repository;

import com.example.proyecto.data.entity.DogWalker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogWalkerRepository extends JpaRepository<DogWalker, Integer> {
    Page<DogWalker> findAll(Pageable pageable);
}
