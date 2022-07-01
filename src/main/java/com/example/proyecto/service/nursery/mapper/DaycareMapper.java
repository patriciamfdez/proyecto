package com.example.proyecto.service.nursery.mapper;

import com.example.proyecto.data.entity.DaycareEntity;
import com.example.proyecto.dto.Daycare;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaycareMapper {
    public Daycare convertEntityToDto(DaycareEntity daycareEntity) {
        Daycare daycareDto = new Daycare();
        daycareDto.setName(daycareEntity.getName());
        daycareDto.setPriceNight(daycareEntity.getNight_price());
        daycareDto.setPhone(daycareEntity.getPhone());
        daycareDto.setEmail(daycareEntity.getEmail());
        daycareDto.setAdress(daycareEntity.getAddress());

        return daycareDto;
    }
}
