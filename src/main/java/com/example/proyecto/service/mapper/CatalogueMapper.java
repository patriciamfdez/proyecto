package com.example.proyecto.service.mapper;

import com.example.proyecto.data.entity.Catalogue;
import com.example.proyecto.dto.CatalogueDTO;
import org.springframework.stereotype.Service;

@Service
public class CatalogueMapper extends  AbstractServiceMapper<Catalogue, CatalogueDTO> {

    @Override
    public Catalogue toEntity(CatalogueDTO dto) {
        final Catalogue entity = new Catalogue();
        entity.setId(dto.getId());
        entity.setServiceType(dto.getServiceType());
        entity.setId_product(dto.getId_product());
        entity.setServiceDescription(dto.getServiceDescription());
        return entity;
    }

    @Override
    public CatalogueDTO toDto(Catalogue entity) {
        final CatalogueDTO dto = new CatalogueDTO();
        dto.setId(entity.getId());
        dto.setServiceType(entity.getServiceType());
        dto.setId_product(entity.getId_product());
        dto.setServiceDescription(entity.getServiceDescription());
        return dto;
    }
}
