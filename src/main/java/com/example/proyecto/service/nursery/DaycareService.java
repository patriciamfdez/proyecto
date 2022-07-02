package com.example.proyecto.service.nursery;

import com.example.proyecto.dto.Daycare;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DaycareService {

    List<Daycare> listNursery();
    List<Daycare> filterNurseryByPrice(String priceMax, String priceMin);
/*
    Page<Daycare> findById(Integer userId, Pageable pageable);

    List<Daycare> filterNurseryByAddress(String address);*/
}
