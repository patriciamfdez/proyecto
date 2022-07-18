package com.example.proyecto.data.repository;

import com.example.proyecto.data.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
