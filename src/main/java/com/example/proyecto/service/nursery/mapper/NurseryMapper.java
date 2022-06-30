package com.example.proyecto.service.nursery.mapper;

import com.example.proyecto.data.entity.NurseryEntity;
import com.example.proyecto.dto.Nursery;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NurseryMapper {
    public Nursery convertEntityToDto(NurseryEntity nurseryEntity) {
        Nursery nurseryDto = new Nursery();
        nurseryDto.setId(nurseryEntity.getId());
        nurseryDto.setName(nurseryEntity.getNombre());
        nurseryDto.setPriceNight(nurseryEntity.getPrecio_noche());
        nurseryDto.setPhone(nurseryEntity.getTelefono());
        nurseryDto.setEmail(nurseryEntity.getEmail());
        nurseryDto.setAdress(nurseryEntity.getDireccion());

        return nurseryDto;
    }
}
