package com.example.proyecto.service.nursery;

import com.example.proyecto.data.entity.DaycareEntity;
import com.example.proyecto.data.repository.DaycareRepository;
import com.example.proyecto.dto.Daycare;
import com.example.proyecto.service.nursery.mapper.DaycareMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DaycareServiceImpl implements DaycareService {

    @Autowired
    private DaycareRepository repository;
    @Autowired
    private DaycareMapper mapper;

    @Override
    public List<Daycare> listNursery() {
        List<Daycare> listDaycareDto = new ArrayList<>();

        List<DaycareEntity> daycareEntityList = repository.findAll();

        daycareEntityList.forEach(nursery -> {
            listDaycareDto.add(mapper.convertEntityToDto(nursery));
        });

        return listDaycareDto;
    }

    @Override
    public List<Daycare> filterNurseryByPrice(String priceMax, String priceMin) {
        List<Daycare> listDaycareDto = new ArrayList<>();

        List<DaycareEntity> daycareEntityList = repository.findPriceFilter(Float.parseFloat(priceMax),Float.parseFloat(priceMin));

        daycareEntityList.forEach(nursery -> {
            listDaycareDto.add(mapper.convertEntityToDto(nursery));
        });

        return listDaycareDto;
    }


    @Override
    public Page<Daycare> findById(Integer userId, Pageable pageable) {

        return null;
    }

    @Override
    public List<Daycare> filterNurseryByAddress(String address) {
        List<Daycare> listDaycareDto = new ArrayList<>();

        List<DaycareEntity> daycareEntityList = repository.findNurseryAddress();
        daycareEntityList.forEach(nursery -> {
            listDaycareDto.add(mapper.convertEntityToDto(nursery));
        });

        return listDaycareDto;
    }

}
