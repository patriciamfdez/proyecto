package com.example.proyecto.data.repository;

import com.example.proyecto.data.entity.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    Page<Address> findAll(Pageable pageable);
}
