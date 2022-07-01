package com.example.proyecto.service.nursery;

import com.example.proyecto.data.entity.DaycareEntity;
import com.example.proyecto.data.repository.NurseryRepository;
import com.example.proyecto.dto.Nursery;
import com.example.proyecto.service.nursery.mapper.NurseryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

        List<DaycareEntity> daycareEntityList = repository.findAll();

        daycareEntityList.forEach(nursery -> {
            listNurseryDto.add(mapper.convertEntityToDto(nursery));
        });

        return listNurseryDto;
    }

    @Override
    public List<Nursery> filterNurseryByPrice(String priceMax, String priceMin) {
        List<Nursery>listNurseryDto = new ArrayList<>();

        List<DaycareEntity> daycareEntityList = repository.findPriceFilter(Float.parseFloat(priceMax),Float.parseFloat(priceMin));

        daycareEntityList.forEach(nursery -> {
            listNurseryDto.add(mapper.convertEntityToDto(nursery));
        });

        return listNurseryDto;
    }


    @Override
    public Page<Nursery> findById(Integer userId, Pageable pageable) {

        return null;
    }

    @Override
    public List<Nursery> filterNurseryByAddress(String address) {
        List<Nursery>listNurseryDto = new ArrayList<>();

        List<DaycareEntity> daycareEntityList = repository.findNurseryAddress();
        daycareEntityList.forEach(nursery -> {
            listNurseryDto.add(mapper.convertEntityToDto(nursery));
        });

        return listNurseryDto;
    }

}
