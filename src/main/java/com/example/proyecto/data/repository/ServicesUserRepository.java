package com.example.proyecto.data.repository;

import com.example.proyecto.data.entity.ServicesUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicesUserRepository extends JpaRepository<ServicesUser, Integer> {
    Page<ServicesUser> findAll(Pageable pageable);
}
