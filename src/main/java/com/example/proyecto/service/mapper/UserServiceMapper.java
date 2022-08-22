package com.example.proyecto.service.mapper;

import com.example.proyecto.data.entity.User;
import com.example.proyecto.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
@Service
public class UserServiceMapper  extends AbstractServiceMapper<User, UserDTO>{
    private final RoleServiceMapper roleServiceMapper;

    public UserServiceMapper(RoleServiceMapper roleServiceMapper) {
        this.roleServiceMapper = roleServiceMapper;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        User entity = new User();
        entity.setId(userDTO.getId());
        entity.setUserName(userDTO.getUserName());
        entity.setPassword(userDTO.getPassword());
        entity.setBirthDate(userDTO.getBirthDate());
        entity.setDate(userDTO.getDate());
        entity.setName(userDTO.getName());
        entity.setSurname(userDTO.getSurname());
        entity.setEmail(userDTO.getEmail());
        entity.setPhone(userDTO.getPhone());
        entity.setActive(userDTO.isActive());
        entity.setRole(this.roleServiceMapper.toEntity(userDTO.getRoles().
                        stream().collect(Collectors.toList())).stream()
                .collect(Collectors.toSet()));
        return entity;
    }

    @Override
    public UserDTO toDto(User entity) {
        UserDTO dto = new UserDTO();
        dto.setId(entity.getId());
        dto.setActive(entity.isActive());
        dto.setUserName(entity.getUserName());
        dto.setBirthDate(entity.getBirthDate());
        dto.setDate(entity.getDate());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setEmail(entity.getEmail());
        dto.setPhone(entity.getPhone());
        //dto.setPassword(); la password no se edita ni se lista
        dto.setRoles(this.roleServiceMapper.toDto(entity.getRole().
                        stream().collect(Collectors.toList())).stream()
                .collect(Collectors.toSet()));
        return dto;
    }
}