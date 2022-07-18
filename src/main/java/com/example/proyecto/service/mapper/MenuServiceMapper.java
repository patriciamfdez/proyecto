package com.example.proyecto.service.mapper;

import com.example.proyecto.data.entity.Menu;
import com.example.proyecto.dto.MenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MenuServiceMapper extends AbstractServiceMapper<Menu, MenuDTO> {

    private final RoleServiceMapper roleServiceMapper;

    @Autowired
    public MenuServiceMapper(RoleServiceMapper roleServiceMapper) {
        this.roleServiceMapper = roleServiceMapper;
    }

    public Menu toEntity(MenuDTO dto) {
        final Menu entity = new Menu();
        entity.setId(dto.getId());
        entity.setDescription(dto.getDescription());
        entity.setActive(dto.getActive());
        entity.setOrder(dto.getOrder());
        entity.setUrl(dto.getUrl());
        entity.setRole(this.roleServiceMapper.toEntity(dto.getRoles().stream().collect(Collectors.toList())).stream()
                .collect(Collectors.toSet()));
        return entity;
    }

    public MenuDTO toDto(Menu entity) {
        final MenuDTO dto = new MenuDTO();
        dto.setId(entity.getId());
        dto.setDescription(entity.getDescription());
        dto.setActive(entity.getActive());
        dto.setOrder(entity.getOrder());
        dto.setUrl(entity.getUrl());
        dto.setRoles(this.roleServiceMapper.toDto(entity.getRole().stream().collect(Collectors.toList())).stream()
                .collect(Collectors.toSet()));
        return dto;
    }

}
