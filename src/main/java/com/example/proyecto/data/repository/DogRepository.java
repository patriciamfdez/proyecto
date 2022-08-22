package com.example.proyecto.data.repository;

import com.example.proyecto.data.entity.Dog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Integer> {
    Page<Dog> findAll(Pageable pageable);
}
