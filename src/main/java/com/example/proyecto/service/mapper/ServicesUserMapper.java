package com.example.proyecto.service.mapper;

import com.example.proyecto.data.entity.ServicesUser;
import com.example.proyecto.dto.ServicesUserDTO;
import com.example.proyecto.utils.DateUtil;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Service
public class ServicesUserMapper extends  AbstractServiceMapper<ServicesUser, ServicesUserDTO> {

    @Override
    public ServicesUser toEntity(ServicesUserDTO servicesUserDTO)  {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        final ServicesUser entity = new ServicesUser();
        entity.setId(servicesUserDTO.getId());
        entity.setUsername(servicesUserDTO.getUsername());
        entity.setBookingStatus(servicesUserDTO.getBookingStatus());
        try {
            entity.setCreationDate(sdf.parse(servicesUserDTO.getCreationDate()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        entity.setServiceName(servicesUserDTO.getServiceName());
        try {
            entity.setBookingStartDate(sdf.parse(servicesUserDTO.getBookingStartDate()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        try {
            entity.setBookingLastDate(sdf.parse(servicesUserDTO.getBookingLastDate()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    @Override
    public ServicesUserDTO toDto(ServicesUser servicesUser) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        final ServicesUserDTO dto = new ServicesUserDTO();
        dto.setId(servicesUser.getId());
        dto.setUsername(servicesUser.getUsername());
        dto.setBookingStatus(servicesUser.getBookingStatus());
        dto.setCreationDate(sdf.format(servicesUser.getCreationDate()));
        dto.setServiceName(servicesUser.getServiceName());
        dto.setBookingStartDate(sdf.format(servicesUser.getBookingStartDate()));
        dto.setBookingLastDate(sdf.format(servicesUser.getBookingLastDate()));
        return dto;
    }
}
