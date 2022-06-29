package com.example.proyecto.service.nursery;

import com.example.proyecto.dto.Nursery;

import java.util.List;

public interface NurseryService {

    List<Nursery> listNursery();
    List<Nursery> filterNurseryByPrice(String priceMax, String priceMin);
}
