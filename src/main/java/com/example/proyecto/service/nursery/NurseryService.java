package com.example.proyecto.service.nursery;

import com.example.proyecto.dto.Nursery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NurseryService {

    List<Nursery> listNursery();
    List<Nursery> filterNurseryByPrice(String priceMax, String priceMin);

    Page<Nursery> findById(Integer userId, Pageable pageable);

    List<Nursery> filterNurseryByAddress(String address);
}
