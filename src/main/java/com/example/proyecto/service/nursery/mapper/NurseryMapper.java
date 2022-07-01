package com.example.proyecto.service.nursery.mapper;

import com.example.proyecto.data.entity.DaycareEntity;
import com.example.proyecto.dto.Nursery;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NurseryMapper {
    public Nursery convertEntityToDto(DaycareEntity daycareEntity) {
        Nursery nurseryDto = new Nursery();
        nurseryDto.setName(daycareEntity.getName());
        nurseryDto.setPriceNight(daycareEntity.getNight_price());
        nurseryDto.setPhone(daycareEntity.getPhone());
        nurseryDto.setEmail(daycareEntity.getEmail());
        nurseryDto.setAdress(daycareEntity.getAddress());

        return nurseryDto;
    }
}
