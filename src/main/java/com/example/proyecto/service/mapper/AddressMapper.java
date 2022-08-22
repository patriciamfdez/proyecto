package com.example.proyecto.service.mapper;

import com.example.proyecto.data.entity.Address;
import com.example.proyecto.dto.AddressDTO;
import org.springframework.stereotype.Service;

@Service
public class AddressMapper extends  AbstractServiceMapper<Address, AddressDTO> {

    @Override
    public Address toEntity(AddressDTO addressDTO) {
        final Address entity = new Address();
        entity.setId(addressDTO.getId());
        entity.setCountry(addressDTO.getCountry());
        entity.setProvince(addressDTO.getProvince());
        entity.setCity(addressDTO.getCity());
        entity.setPostalCode(addressDTO.getPostalCode());
        entity.setAddress(addressDTO.getAddress());
        return entity;
    }

    @Override
    public AddressDTO toDto(Address address) {
        final AddressDTO dto = new AddressDTO();
        dto.setId(address.getId());
        dto.setCountry(address.getCountry());
        dto.setProvince(address.getProvince());
        dto.setCity(address.getCity());
        dto.setPostalCode(address.getPostalCode());
        dto.setAddress(address.getAddress());
        return dto;
    }
}
