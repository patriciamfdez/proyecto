package com.example.proyecto.service.nursery;

import com.example.proyecto.data.entity.NurseryEntity;
import com.example.proyecto.data.repository.NurseryRepository;
import com.example.proyecto.dto.Nursery;
import com.example.proyecto.service.nursery.mapper.NurseryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.naming.directory.SearchResult;
import java.util.ArrayList;
import java.util.List;

@Service
public class NurseryServiceImpl implements NurseryService{

    @Autowired
    private NurseryRepository repository;
    @Autowired
    private NurseryMapper mapper;

    @Override
    public List<Nursery> listNursery() {
        List<Nursery>listNurseryDto = new ArrayList<>();

        List<NurseryEntity> nurseryEntityList = repository.findAll();

        nurseryEntityList.forEach(nursery -> {
            listNurseryDto.add(mapper.convertEntityToDto(nursery));
        });

        return listNurseryDto;
    }

    @Override
    public List<Nursery> filterNurseryByPrice(String priceMax, String priceMin) {
        List<Nursery>listNurseryDto = new ArrayList<>();

        List<NurseryEntity> nurseryEntityList = repository.findPriceFilter(Float.parseFloat(priceMax),Float.parseFloat(priceMin));

        nurseryEntityList.forEach(nursery -> {
            listNurseryDto.add(mapper.convertEntityToDto(nursery));
        });

        return listNurseryDto;
    }


    @Override
    public Page<Nursery> findById(Integer userId, Pageable pageable) {

        return null;
    }


}
