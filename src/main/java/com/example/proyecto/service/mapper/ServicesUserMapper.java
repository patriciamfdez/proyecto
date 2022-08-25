package com.example.proyecto.service.mapper;

import com.example.proyecto.data.entity.ServicesUser;
import com.example.proyecto.dto.ServicesUserDTO;
import com.example.proyecto.utils.DateUtil;
import org.springframework.stereotype.Service;

@Service
public class ServicesUserMapper extends  AbstractServiceMapper<ServicesUser, ServicesUserDTO> {

    @Override
    public ServicesUser toEntity(ServicesUserDTO servicesUserDTO) {
        final ServicesUser entity = new ServicesUser();
        entity.setId(servicesUserDTO.getId());
        entity.setUsername(servicesUserDTO.getUsername());
        entity.setBookingStatus(servicesUserDTO.getBookingStatus());
        entity.setCreationDate(servicesUserDTO.getCreationDate());
        entity.setServiceName(servicesUserDTO.getServiceName());
        entity.setBookingStartDate(servicesUserDTO.getBookingStartDate());
        entity.setBookingLastDate(servicesUserDTO.getBookingLastDate());
        return entity;
    }

    @Override
    public ServicesUserDTO toDto(ServicesUser servicesUser) {
        final ServicesUserDTO dto = new ServicesUserDTO();
        dto.setId(servicesUser.getId());
        dto.setUsername(servicesUser.getUsername());
        dto.setBookingStatus(servicesUser.getBookingStatus());
        dto.setCreationDate(servicesUser.getCreationDate());
        dto.setServiceName(servicesUser.getServiceName());
        dto.setBookingStartDate(servicesUser.getBookingStartDate());
        dto.setBookingLastDate(servicesUser.getBookingLastDate());
        return dto;
    }
}
